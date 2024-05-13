package com.vivich.starlitapp.ui.lobby

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LobbyScreen(
    openDrawer: () -> Unit
) {
    Scaffold(
        topBar = {
            LobbyTopNav(openDrawer)
        }
    ){innerPadding->
        val screenModifier = Modifier.padding(innerPadding)
        Text(text = "Screen Content (Lobby)", modifier = screenModifier)
    }
}