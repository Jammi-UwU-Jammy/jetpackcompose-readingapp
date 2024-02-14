package com.vivich.starlitapp.ui.lobby

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun LobbyTopNav(
    openDrawer: () -> Unit
){
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = openDrawer,
            icon = {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        )

        NavigationBarItem(
            modifier = Modifier.weight(2.0f),
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Row(
                    modifier = Modifier.padding(20.dp, 5.dp)
                ) {
                    TextField(
                        modifier = Modifier.weight(0.5f),
                        value = TextFieldValue("Some text"),
                        onValueChange = {}
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Find something"
                        )
                    }
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Account")
            }
        )
    }
}