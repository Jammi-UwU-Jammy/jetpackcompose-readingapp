package com.vivich.starlitapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.vivich.starlitapp.R
import com.vivich.starlitapp.ui.theme.StarlitAppTheme

@Composable
fun AppLeftDrawer(
    currentRoute: String,
    navigationToLobby: () -> Unit,
    navigationToSettings: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier

){
    ModalDrawerSheet(
        modifier=modifier
    ){
        NavigationDrawerItem(
            label = { /*TODO*/ },
            selected = false,
            onClick = { /*TODO*/ }
        )
        NavigationDrawerItem(
            label = { /*TODO*/ },
            selected = false,
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun DrawerLogo(
    modifier: Modifier = Modifier
){
    Row(modifier = modifier){
        Icon(
            painterResource(id = R.drawable.ic_launcher_foreground),
            "Logo",
            tint=MaterialTheme.colorScheme.surfaceTint
        )
    }
}

@Preview
@Composable
fun PreviewAppLeftDrawer(){
    StarlitAppTheme {
        AppLeftDrawer(
            currentRoute = StarlitDestinations.LOBBY_ROUTE,
            navigationToLobby = { /*TODO*/ },
            navigationToSettings = { /*TODO*/ },
            closeDrawer = { /*TODO*/ })
    }
}