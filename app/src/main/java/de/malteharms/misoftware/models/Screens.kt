package de.malteharms.misoftware.models

sealed class Screens(val route : String) {
    object Home : Screens("home_route")
    object Functions : Screens("function_route")
    object Statistic : Screens("statistic_route")
    object Settings : Screens("settings_route")
    object Costs : Screens("costs_route")
    object Shopping : Screens("shopping_route")
    object Todo : Screens("todo_route")
    object Notes : Screens("notes_route")
}