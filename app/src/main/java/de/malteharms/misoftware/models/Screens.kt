package de.malteharms.misoftware.models

sealed class Screens(val route : String) {
    object Home : Screens("home_route")
    object Functions : Screens("function_route")
    object Statistic : Screens("statistic_route")
    object Settings : Screens("settings_route")
}