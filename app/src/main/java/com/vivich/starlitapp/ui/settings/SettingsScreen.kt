package com.vivich.starlitapp.ui.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vivich.starlitapp.ui.lobby.LobbyTopNav

@Composable
fun SettingsScreen(
    openDrawer: () -> Unit
) {
    Scaffold(
        topBar = {
            LobbyTopNav(openDrawer)
        }
    ){innerPadding->
        val screenModifier = Modifier.padding(innerPadding)
        Text(text = "This is Content (Settings)", modifier = screenModifier)
    }
}