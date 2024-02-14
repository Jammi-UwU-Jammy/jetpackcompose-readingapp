package com.vivich.starlitapp.ui.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            Text(text = "This is Settings' top bar")
        }
    ){innerPadding->
        val screenModifier = Modifier.padding(innerPadding)
        Text(text = "This is Content (Settings)", modifier = screenModifier)
    }
}