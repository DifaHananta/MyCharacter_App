package com.dicoding.jetmycharacter.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object About: Screen("about")
    object Detail: Screen("home/{characterId}") {
        fun createRoute(characterId: Long) = "home/$characterId"
    }
}
