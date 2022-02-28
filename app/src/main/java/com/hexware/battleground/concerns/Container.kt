package com.hexware.battleground.concerns

object Container {
    private lateinit var navigation: ScreenActions

    fun navigate(route: String) {
        this.navigation.navigate(route)
    }

    fun withNavigation(navContainer: ScreenActions): Container {
        this.navigation = navContainer

        return this
    }
}