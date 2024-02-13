package com.vivich.starlitapp.ui.lobby

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LobbyFeedWithArticleDetailsScreen(
    uiState: LobbyUIState,
    showTopAppBar: Boolean,
    onToggleFavorite: (String) -> Unit,
    onSelectPost: (String) -> Unit,
    onRefreshPosts: () -> Unit,
    onErrorDismiss: (Long) -> Unit,
    onInteractWithList: () -> Unit,
    onInteractWithDetail: (String) -> Unit,
    openDrawer: () -> Unit,
    homeListLazyListState: LazyListState,
    articleDetailLazyListStates: Map<String, LazyListState>,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    onSearchInputChanged: (String) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Article Detail Screen")
    }
}

@Composable
fun LobbyFeedScreen(
    uiState: LobbyUIState,
    showTopAppBar: Boolean,
    onToggleFavorite: (String) -> Unit,
    onSelectPost: (String) -> Unit,
    onRefreshPosts: () -> Unit,
    onErrorDismiss: (Long) -> Unit,
    openDrawer: () -> Unit,
    homeListLazyListState: LazyListState,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    searchInput: String = "",
    onSearchInputChanged: (String) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Lobby Feed Screen")
    }
}