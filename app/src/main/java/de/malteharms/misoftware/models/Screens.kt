package de.malteharms.misoftware.models

sealed class Screens(val route : String) {
    object FirstEverStart : Screens("start_route")
    object StartMIApp : Screens("mi_app_route")
    object Home : Screens("home_route")
    object Costs : Screens("costs_route")
    object Shopping : Screens("shopping_route")
    object Todo : Screens("todo_route")
    object Notes : Screens("notes_route")
    object Profile : Screens("profile_route")
}
