package com.vivich.starlitapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.vivich.starlitapp.StarlitApplication.Companion.STARLIT_APP_URI
import com.vivich.starlitapp.data.AppContainer
import com.vivich.starlitapp.ui.lobby.LobbyViewModel


const val POST_ID = "postId"

@@Composable
fun StarlitNavGraph(
    appContainer: AppContainer,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit= {},
    startDestination: String = StarlitDestinations.LOBBY_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){
        composable(
            route = StarlitDestinations.LOBBY_ROUTE,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern="$STARLIT_APP_URI/${StarlitDestinations.LOBBY_ROUTE}?$POST_ID={$POST_ID}"
                }
            )
        ){
            val lobbyViewModel : LobbyViewModel = viewModel(
                factory = LobbyViewModel.provideFactory(
                    postsRepository = appContainer.postsRepo,
                    preSelectedPostId = it.arguments?.getString(POST_ID)
                )
            )
            LobbyRoute(

            )
        }
    }
}