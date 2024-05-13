package com.vivich.starlitapp.ui.settings

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.vivich.starlitapp.ui.lobby.LobbyScreen

@Composable
fun SettingsRoute(
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    // others
){
    SettingsScreen(openDrawer)
}