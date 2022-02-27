package com.hexware.battleground.concerns

sealed class Screen(val route: String) {
    object Start : Screen("start")

    // Add more as needed
}
