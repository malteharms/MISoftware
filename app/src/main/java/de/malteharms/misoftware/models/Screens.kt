package de.malteharms.misoftware.models

sealed class Screens(val route : String) {
    object Home : Screens("home_route")
    object Costs : Screens("costs_route")
    object Shopping : Screens("shopping_route")
    object Todo : Screens("todo_route")
    object Profile : Screens("profile_route")
}
