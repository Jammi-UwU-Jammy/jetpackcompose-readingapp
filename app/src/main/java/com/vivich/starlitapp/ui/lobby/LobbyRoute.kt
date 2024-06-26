package com.vivich.starlitapp.ui.lobby

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun LobbyRoute(
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    // others
){
    LobbyScreen(openDrawer)
}