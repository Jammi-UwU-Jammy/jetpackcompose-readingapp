package com.vivich.starlitapp.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object StarlitDestinations{
    const val LOBBY_ROUTE = "lobby"
    const val SETTINGS_ROUTE = "settings"
}

class StarlitNavigationActions(navController: NavController){
    val navigateToLobby: () -> Unit = {
        navController.navigate(StarlitDestinations.LOBBY_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToSettings: () -> Unit = {
        navController.navigate(StarlitDestinations.SETTINGS_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}