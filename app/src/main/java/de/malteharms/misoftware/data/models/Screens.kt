package de.malteharms.misoftware.data.models

sealed class Screens(val route : String) {
    data object WelcomeRoute : Screens("welcome_route")
    data object LoginRoute : Screens("login_route")
    data object RegisterRoute : Screens("register_route")
    data object HomeRoute : Screens("home_route")
    data object ProfileRoute : Screens("profile_route")
    data object SettingsRoute : Screens("settings_route")

}

sealed class NestedRoutes(val route : String) {
    data object AuthRoute : NestedRoutes("authentication")
    data object MainRoute : NestedRoutes("main_route")
}