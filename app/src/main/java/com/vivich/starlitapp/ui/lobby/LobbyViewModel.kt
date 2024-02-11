package com.vivich.starlitapp.ui.lobby

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vivich.starlitapp.R
import com.vivich.starlitapp.data.GETResult
import com.vivich.starlitapp.data.posts.PostsRepo
import com.vivich.starlitapp.model.post.Post
import com.vivich.starlitapp.model.post.PostsFeed
import com.vivich.starlitapp.utils.ErrorMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

sealed interface LobbyUIState{
    val isLoading: Boolean
    val errorMessages: List<ErrorMessage>
    val searchInput: String

    data class NoPosts(
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>,
        override val searchInput: String
    ) : LobbyUIState

    data class HasPosts(
        val postsFeed: PostsFeed,
        val selectedPost: Post,
        val isArticleOpen: Boolean,
        val favorites: Set<String>,
        override val isLoading: Boolean,
        override val searchInput: String,
        override val errorMessages: List<ErrorMessage>,
    ) : LobbyUIState
}


private data class LobbyViewModelState(
    val postsFeed: PostsFeed?= null,
    val selectedPostId: String? = null,
    val isArticleOpen: Boolean = false,
    val favorites: Set<String> = emptySet(),
    val isLoading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList(),
    val searchInput: String = "",
){
    fun toUIState() : LobbyUIState =
        if (postsFeed == null){
            LobbyUIState.NoPosts(
                isLoading = isLoading,
                errorMessages = errorMessages,
                searchInput=searchInput,
            )
        } else{
            LobbyUIState.HasPosts(
                postsFeed = postsFeed,
                selectedPost=postsFeed.allPosts.find {
                    it.id == selectedPostId
                } ?: postsFeed.highlightedPost,
                isArticleOpen=isArticleOpen,
                favorites=favorites,
                isLoading = isLoading,
                errorMessages=errorMessages,
                searchInput = searchInput
            )
        }
}

class LobbyViewModel(
    private  val postsRepo: PostsRepo,
    preSelectedPostId: String?
): ViewModel(){
    private  val viewModelState = MutableStateFlow(
        LobbyViewModelState(
            isLoading = true,
            selectedPostId = preSelectedPostId,
            isArticleOpen = preSelectedPostId != null
        )
    )

    val uiState = viewModelState
        .map(LobbyViewModelState::toUIState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUIState()
        )

    init {

    }
    fun refreshPosts() {
        // Ui state is refreshing
        viewModelState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = postsRepo.getPostsFeed()
            viewModelState.update {
                when (result) {
                    is GETResult.Success -> it.copy(postsFeed = result.data, isLoading = false)
                    is GETResult.Error -> {
                        val errorMessages = it.errorMessages + ErrorMessage(
                            id = UUID.randomUUID().mostSignificantBits,
                            messageId = R.string.load_error
                        )
                        it.copy(errorMessages = errorMessages, isLoading = false)
                    }
                }
            }
        }
    }

    companion object {
        fun provideFactory(
            postsRepository: PostsRepo,
            preSelectedPostId: String? = null
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LobbyViewModel(postsRepository, preSelectedPostId) as T
            }
        }
    }
}