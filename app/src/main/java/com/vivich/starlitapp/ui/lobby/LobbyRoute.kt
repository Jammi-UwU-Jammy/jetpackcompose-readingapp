package com.vivich.starlitapp.ui.lobby

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember


@Composable
fun LobbyRoute(
    lobbyViewModel: LobbyViewModel,
    openDrawer : () -> Unit,
    snackbarHostState: SnackbarHostState = remember{SnackbarHostState()}
){
    val uiState by lobbyViewModel.uiState.collectAsState()

}

@@Composable
fun LobbyRoute(
    uiState: LobbyUIState,
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
            post.id to rememberLazyListState( s )
        }
    }
}