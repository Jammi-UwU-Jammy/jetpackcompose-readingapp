package com.vivich.starlitapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.vivich.starlitapp.StarlitApplication.Companion.STARLIT_APP_URI
import com.vivich.starlitapp.ui.lobby.LobbyRoute
import com.vivich.starlitapp.ui.settings.SettingsRoute

const val POST_ID = "postId"

@Composable
fun StarlitNavGraph(
//    appContainer: AppContainer,
    openDrawer: () -> Unit= {},
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = StarlitDestinations.LOBBY_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){

        composable(
            route = StarlitDestinations.LOBBY_ROUTE,
        ){
            // TODO: Lobby
            LobbyRoute(openDrawer = openDrawer)
        }
        composable(
            route = StarlitDestinations.SETTINGS_ROUTE,
        ){
            //TODO: Settings
            SettingsRoute(openDrawer = openDrawer)
        }

//        navigation(
//            startDestination =StarlitDestinations.LOGIN_ROUTE,
//            route=StarlitDestinations.AUTH_ROUTE
//        ){
//            composable(
//                route = StarlitDestinations.LOGIN_ROUTE,
//            ){
//                //TODO: log in
//                val viewModel = it.sharedViewModel<StarlitViewModel>(navController = navController)
//            }
//        }
//        navigation(
//            startDestination = StarlitDestinations.LOBBY_ROUTE,
//            route="lobby"
//        ){
//            composable(
//                route = StarlitDestinations.LOBBY_ROUTE,
//            ){
//                // TODO: Lobby
//            }
//            composable(
//                route = StarlitDestinations.SETTINGS_ROUTE,
//            ){
//                //TODO: Settings
//            }
//        }
    }
}

@Composable
fun <T> NavBackStackEntry.sharedViewModel(navController: NavHostController) : T{
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this){
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}