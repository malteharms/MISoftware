package de.malteharms.misoftware

import LoginPage
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.malteharms.misoftware.connection.KtorRealtimeMessagingClient
import de.malteharms.misoftware.models.Screens
import de.malteharms.misoftware.ui.screens.hello.HelloMIApp
import de.malteharms.misoftware.ui.screens.MainMIApp
import de.malteharms.misoftware.ui.screens.costs.MIViewModel
import de.malteharms.misoftware.ui.screens.hello.RegisterPage
import de.malteharms.misoftware.ui.theme.MISoftwareTheme
import de.malteharms.misoftware.utils.SharedPreferencesManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets

class MainActivity : ComponentActivity() {

    private val client = HttpClient(CIO) {
        install(Logging)
        install(WebSockets)
    }

    private val realtimeMessagingClient = KtorRealtimeMessagingClient(client)
    private val viewModel = MIViewModel(realtimeMessagingClient)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferencesManager: SharedPreferencesManager =
            SharedPreferencesManager.getInstance(
                getSharedPreferences("MISP", Context.MODE_PRIVATE))

        setContent {
            MISoftwareTheme {
                MyApp(
                    spm = sharedPreferencesManager,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
private fun MyApp(
    spm: SharedPreferencesManager,
    viewModel: MIViewModel
) {

    // determine, where to start the app
    val firstPage: String = if (spm.contains("profile_uuid")) {
        Screens.MainRoute.route     // the user is already logged in
    } else {
        Screens.HelloRoute.route    // the user has to create an account or has to login
    }

    // setup navigation
    val navController = rememberNavController()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {

        NavHost(
            navController = navController,
            startDestination = firstPage,
        ) {
            composable(Screens.HelloRoute.route) {
                HelloMIApp(navigator = navController)
            }
            composable(Screens.MainRoute.route) {
                MainMIApp(navigator = navController)
            }
            composable(Screens.RegisterRoute.route) {
                RegisterPage(
                    registerFunction = viewModel::register
                )
            }
            composable(Screens.LoginRoute.route) {
                LoginPage()
            }
        }
    }

}



/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
    viewModel: CostsViewModel
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        val navController = rememberNavController()

        Scaffold(
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
                composable(Screens.Costs.route) {
                    val state by viewModel.state.collectAsState()

                    CostsPage(
                        navController = navController,
                        state = state,
                        addItemFunction = viewModel::addItem
                    )
                }
                composable(Screens.Todo.route) {
                    TodoPage(navController = navController)
                }
                composable(Screens.Shopping.route) {
                    ShoppingPage(navController = navController)
                }
            }
        }
    }
}

 */