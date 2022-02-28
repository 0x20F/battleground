package com.hexware.battleground.concerns

import androidx.navigation.NavController

sealed class Screen(val route: String) {
    object Start: Screen("start")

    // Add more as needed
    object WebRequests: Screen("web-req")
}

class ScreenActions(navController: NavController) {
    val navigateBack: () -> Unit = {
        navController.navigateUp()
    }

    val navigate: (route: String) -> Unit = {
        navController.navigate(it)
    }
}