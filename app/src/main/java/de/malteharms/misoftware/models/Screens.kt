package de.malteharms.misoftware.models

sealed class Screens(val route : String) {
    object HelloRoute : Screens("hello_route")
    object RegisterRoute : Screens("register_route")
    object LoginRoute : Screens("login_route")

    object MainRoute : Screens("home_route")
    object Home : Screens("home_route")
    object Costs : Screens("costs_route")
}
