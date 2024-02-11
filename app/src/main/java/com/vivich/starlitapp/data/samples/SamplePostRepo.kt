package com.vivich.starlitapp.data.samples

import com.vivich.starlitapp.data.GETResult
import com.vivich.starlitapp.data.posts.PostsRepo
import com.vivich.starlitapp.model.post.Post
import com.vivich.starlitapp.model.post.PostsFeed
import com.vivich.starlitapp.utils.addOrRemove
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

class SamplePostRepo : PostsRepo {

    private val favorites = MutableStateFlow<Set<String>>(setOf())

    private val postsFeed = MutableStateFlow<PostsFeed?>(null)

    override suspend fun getPost(postId: String?): GETResult<Post> {
        return withContext(Dispatchers.IO){
            val post = posts.allPosts.find { it.id == postId }
            if (post == null) {
                GETResult.Error(IllegalArgumentException("Post not found"))
            } else {
                GETResult.Success(post)
            }
        }
    }

    override suspend fun getPostsFeed(): GETResult<PostsFeed> {
        return withContext(Dispatchers.IO) {
            delay(800) // pretend we're on a slow network
            if (shouldRandomlyFail()) {
                GETResult.Error(IllegalStateException())
            } else {
                postsFeed.update { posts }
                GETResult.Success(posts)
            }
        }
    }

    override fun observeFavorites(): Flow<Set<String>> {
        TODO("Not yet implemented")
    }

    override fun observePostsFeed(): Flow<PostsFeed?> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavorite(postId: String) {
        favorites.update {
            it.addOrRemove(postId)
        }
    }

    private var requestCount = 0
    /**
     * Randomly fail some loads to simulate a real network.
     *
     * This will fail deterministically every 5 requests
     */
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}