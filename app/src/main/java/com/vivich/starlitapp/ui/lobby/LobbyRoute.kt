package com.vivich.starlitapp.ui.lobby

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember


private enum class LobbyScreenType {
    FeedWithArticleDetails,
    Feed,
    ArticleDetails
}

@Composable
fun LobbyRoute(
    lobbyViewModel: LobbyViewModel,
    isExpandedScreen: Boolean,
    openDrawer : () -> Unit,
    snackbarHostState: SnackbarHostState = remember{SnackbarHostState()}
){
    val uiState by lobbyViewModel.uiState.collectAsState()

    LobbyRoute(
        uiState = uiState,
        isExpandedScreen= isExpandedScreen,
        onToggleFavourite = {lobbyViewModel.toggleFavourite(it)},
        onSelectPost = {lobbyViewModel.selectArticle(it)},
        onRefreshPosts = { lobbyViewModel.refreshPosts() },
        onErrorDismiss = {lobbyViewModel.errorShown(it)},
        onInteractWithFeed = { lobbyViewModel.interactedWithFeed() },
        onInteractWithArticleDetails = {lobbyViewModel.interactedWithArticleDetails(it)},
        onSearchInputChanged = {lobbyViewModel.onSearchInputChanged(it)},
        openDrawer = openDrawer,
        snackbarHostState =snackbarHostState
    )
}

@Composable
fun LobbyRoute(
    uiState: LobbyUIState,
    isExpandedScreen: Boolean,
    onToggleFavourite: (String) -> Unit,
    onSelectPost: (String) -> Unit,
    onRefreshPosts: () -> Unit,
    onErrorDismiss: (Long) -> Unit,
    onInteractWithFeed: () -> Unit,
    onInteractWithArticleDetails: (String) -> Unit,
    onSearchInputChanged: (String) -> Unit,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState
) {
    val lobbyListLazyListState = rememberLazyListState()
    val articleDetailLazyListStates = when (uiState){
        is LobbyUIState.HasPosts -> uiState.postsFeed.allPosts
        is LobbyUIState.NoPosts-> emptyList()
    }.associate { post ->
        key (post.id){
            post.id to rememberLazyListState(  )
        }
    }

    val lobbyScreenType = getLobbyScreenType(
        isExpandedScreen = isExpandedScreen,
        uiState = uiState
    )

    when(lobbyScreenType){
        LobbyScreenType.FeedWithArticleDetails->{
            LobbyFeedWithArticleDetailsScreen(
                uiState = uiState,
                showTopAppBar = !isExpandedScreen,
                onToggleFavorite = onToggleFavourite,
                onSelectPost = onSelectPost,
                onRefreshPosts = onRefreshPosts,
                onErrorDismiss = onErrorDismiss,
                onInteractWithList = onInteractWithFeed,
                onInteractWithDetail = onInteractWithArticleDetails,
                openDrawer = openDrawer,
                homeListLazyListState = lobbyListLazyListState,
                articleDetailLazyListStates = articleDetailLazyListStates,
                snackbarHostState = snackbarHostState,
                onSearchInputChanged = onSearchInputChanged
            )
        }
        LobbyScreenType.Feed->{
            LobbyFeedScreen(
                uiState = ,
                showTopAppBar = ,
                onToggleFavorite = ,
                onSelectPost = ,
                onRefreshPosts = { /*TODO*/ },
                onErrorDismiss = ,
                openDrawer = { /*TODO*/ },
                homeListLazyListState = ,
                snackbarHostState = ,
                onSearchInputChanged = 
            )
        }
    }
}

@Composable
private fun getLobbyScreenType(
    isExpandedScreen: Boolean,
    uiState: LobbyUIState
): LobbyScreenType = when (isExpandedScreen) {
    false -> {
        when (uiState) {
            is LobbyUIState.HasPosts -> {
                if (uiState.isArticleOpen) {
                    LobbyScreenType.ArticleDetails
                } else {
                    LobbyScreenType.Feed
                }
            }
            is LobbyUIState.NoPosts -> LobbyScreenType.Feed
        }
    }
    true -> LobbyScreenType.FeedWithArticleDetails
}