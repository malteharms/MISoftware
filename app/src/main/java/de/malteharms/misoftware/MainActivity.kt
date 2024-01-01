package de.malteharms.misoftware

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.malteharms.misoftware.connection.KtorRealtimeMessagingClient
import de.malteharms.misoftware.models.Screens
import de.malteharms.misoftware.ui.components.BottomNavigationBar
import de.malteharms.misoftware.ui.screens.HomeScreen
import de.malteharms.misoftware.ui.screens.costs.CostsPage
import de.malteharms.misoftware.ui.screens.costs.CostsViewModel
import de.malteharms.misoftware.ui.screens.shopping.ShoppingPage
import de.malteharms.misoftware.ui.screens.todo.TodoPage
import de.malteharms.misoftware.ui.theme.MISoftwareTheme
import de.malteharms.misoftware.utils.SharedPreferencesManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.websocket.Frame
import kotlinx.coroutines.runBlocking

private const val TAG = "MyActivity"

class MainActivity : ComponentActivity() {

    private val client = HttpClient(CIO) {
        install(Logging)
        install(WebSockets)
    }

    private val realtimeMessagingClient = KtorRealtimeMessagingClient(client)

    private val viewModel = CostsViewModel(realtimeMessagingClient)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferencesManager: SharedPreferencesManager =
            SharedPreferencesManager.getInstance(
                getSharedPreferences("MISP", Context.MODE_PRIVATE))

        setContent {
            MISoftwareTheme {
                MyApp(
                    modifier = Modifier.fillMaxSize(),
                    viewModel = viewModel
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
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