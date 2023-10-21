package de.malteharms.misoftware

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.malteharms.misoftware.models.Screens
import de.malteharms.misoftware.ui.components.AppBar
import de.malteharms.misoftware.ui.components.BottomNavigationBar
import de.malteharms.misoftware.ui.components.screens.FunctionScreen
import de.malteharms.misoftware.ui.components.screens.HomeScreen
import de.malteharms.misoftware.ui.components.screens.SettingsScreen
import de.malteharms.misoftware.ui.components.screens.StatistcScreen
import de.malteharms.misoftware.ui.theme.MISoftwareTheme
import de.malteharms.misoftware.utils.SharedPreferencesManager

private const val TAG = "MyActivity"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferencesManager: SharedPreferencesManager =
            SharedPreferencesManager.getInstance(
                getSharedPreferences("MISP", Context.MODE_PRIVATE))

        setContent {
            MISoftwareTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        val navController = rememberNavController()

        Scaffold(
            topBar = { AppBar() },
            bottomBar = { BottomNavigationBar(navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screens.Home.route,
                modifier = Modifier.padding(paddingValues = paddingValues)
            ) {
                composable(Screens.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(Screens.Functions.route) {
                    FunctionScreen(navController = navController)
                }
                composable(Screens.Statistic.route) {
                    StatistcScreen(navController = navController)
                }
                composable(Screens.Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
    }
}