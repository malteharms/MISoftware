package de.malteharms.misoftware

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import de.malteharms.misoftware.data.models.NestedRoutes
import de.malteharms.misoftware.data.models.Screens
import de.malteharms.misoftware.domain.SharedPreferencesManager
import de.malteharms.misoftware.ui.screens.HomePage
import de.malteharms.misoftware.ui.screens.WelcomePage
import de.malteharms.misoftware.ui.theme.MISoftwareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPreferencesManager: SharedPreferencesManager =
            SharedPreferencesManager.getInstance(
                getSharedPreferences("MISP", Context.MODE_PRIVATE))

        super.onCreate(savedInstanceState)
        setContent {
            MISoftwareTheme {

                MIAppEntry(spm = sharedPreferencesManager)

            }
        }
    }
}


@Composable
fun MIAppEntry(
    spm: SharedPreferencesManager
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NestedRoutes.MainRoute.route) {

        // general pages available from anywhere

        // navigation graph for authentication procedure
        navigation(
            startDestination = Screens.WelcomeRoute.route,
            route = NestedRoutes.AuthRoute.route
        ) {
            composable(Screens.WelcomeRoute.route) {
                WelcomePage(navController = navController, spm = spm)
            }
            composable(Screens.LoginRoute.route) {

            }
            composable(Screens.RegisterRoute.route) {

            }
        }

        // navigation graph for main app usage
        navigation(
            startDestination = Screens.HomeRoute.route,
            route = NestedRoutes.MainRoute.route
        ) {
            composable(Screens.HomeRoute.route) {
                HomePage(navController = navController, spm = spm)
            }
            composable(Screens.ProfileRoute.route) {

            }
            composable(Screens.SettingsRoute.route) {

            }
        }
    }
}