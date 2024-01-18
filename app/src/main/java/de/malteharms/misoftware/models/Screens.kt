package de.malteharms.misoftware.models

sealed class Screens(val route : String) {
    object MainRoute : Screens("home_route")
    object HelloRoute : Screens("hello_route")
    object Home : Screens("home_route")
    object Costs : Screens("costs_route")
}
