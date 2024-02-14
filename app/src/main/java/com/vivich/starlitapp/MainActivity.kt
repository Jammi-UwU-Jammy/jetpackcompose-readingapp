package com.vivich.starlitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vivich.starlitapp.ui.AppLeftDrawer
import com.vivich.starlitapp.ui.StarlitDestinations
import com.vivich.starlitapp.ui.StarlitNavGraph
import com.vivich.starlitapp.ui.StarlitNavigationActions
import com.vivich.starlitapp.ui.theme.StarlitAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarlitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    StarlitTestRun()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun StarlitTestRun(

){
    StarlitAppTheme {

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            StarlitNavigationActions(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: StarlitDestinations.LOBBY_ROUTE
        val coroutineScope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        ModalNavigationDrawer(
            drawerContent = {
                AppLeftDrawer(
                    currentRoute = currentRoute,
                    navigationToLobby = {
//                        navigationActions.navigateToLobby
                        navController.navigate(StarlitDestinations.LOBBY_ROUTE)
                    },
                    navigationToSettings = {
//                        navigationActions.navigateToSettings
                        navController.navigate(StarlitDestinations.SETTINGS_ROUTE)
                    },
                    closeDrawer = { coroutineScope.launch { drawerState.close() } })
            },
            drawerState = drawerState
        ){
            Row{
                StarlitNavGraph(
                    openDrawer = {coroutineScope.launch { drawerState.open() }},
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StarlitAppTheme {
        Greeting("Android")
    }
}