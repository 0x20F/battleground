package com.hexware.battleground

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hexware.battleground.concerns.Container
import com.hexware.battleground.concerns.Screen
import com.hexware.battleground.concerns.ScreenActions
import com.hexware.battleground.ui.screens.StartScreen
import com.hexware.battleground.ui.screens.WebRequests
import com.hexware.battleground.ui.screens.WebRequestsViewModel

@Composable
fun Navigation() {
    val controller = rememberNavController()
    val actions = ScreenActions(navController = controller)
    Container.withNavigation(actions)

    // For now this is fine since it's just a single view
    // model. The more we got the more we should consider using
    // hilt and injecting them.
    val reqVm = WebRequestsViewModel()

    NavHost(
        navController = controller,
        startDestination = Screen.Start.route
    ) {
        composable(Screen.Start.route) { StartScreen() }
        composable(Screen.WebRequests.route) { WebRequests(reqVm) }
    }
}