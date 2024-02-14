package com.vivich.starlitapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        DrawerLogo()

        NavigationDrawerItem(
            label = { Text(text = "Lobby") },
            selected = currentRoute==StarlitDestinations.LOBBY_ROUTE,
            onClick = {
                      navigationToLobby(); closeDrawer()
                //navigate to a screen
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text(text = "Settings") },
            selected = currentRoute==StarlitDestinations.SETTINGS_ROUTE,
            onClick = {
                navigationToSettings(); closeDrawer()
                //navigate to a screen
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
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
//        Spacer(Modifier.width(8.dp))
        Text(text = "Profile?")
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