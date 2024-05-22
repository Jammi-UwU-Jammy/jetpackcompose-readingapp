package com.vivich.starlitapp.ui.lobby


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyTopNav(
    openDrawer: () -> Unit
){
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

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
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SearchBar(
                        placeholder = {
                            Row {
                                Icon(imageVector = Icons.Default.Search , contentDescription = "Searchbar",  Modifier.alpha(0.3f))
                                Text(text = "Search", Modifier.alpha(0.3f))
                            }
                        },
                        query = text,
                        onQueryChange = { text = it },
                        onSearch = { active = false },
                        active = active,
                        onActiveChange = {
                            active = it
                        }
                    ) {
                        // Search result shown when active
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            items(4) { idx ->
                                // Search result

                            }
                        }

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


@Preview
@Composable
fun TopBarPreview(){
    LobbyTopNav {

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(

){
    var text by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }


}
