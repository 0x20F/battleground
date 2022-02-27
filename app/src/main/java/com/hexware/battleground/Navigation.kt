package com.hexware.battleground

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hexware.battleground.concerns.Screen
import com.hexware.battleground.ui.screens.StartScreen

@Composable
fun Navigation() {
    val controller = rememberNavController()

    NavHost(
        navController = controller,
        startDestination = Screen.Start.route
    ) {
        composable(Screen.Start.route) { StartScreen() }
    }
}