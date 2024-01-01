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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.malteharms.misoftware.models.Screens
import de.malteharms.misoftware.ui.components.BottomNavigationBar
import de.malteharms.misoftware.ui.screens.HomeScreen
import de.malteharms.misoftware.ui.screens.costs.CostsPage
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferencesManager: SharedPreferencesManager =
            SharedPreferencesManager.getInstance(
                getSharedPreferences("MISP", Context.MODE_PRIVATE))

        val client = HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
        }

        runBlocking {
            client.webSocket(method = HttpMethod.Get, host = "192.168.178.28", port = 8080, path = "/costs") {
                val message = "new_item#Hi :)"
                send(Frame.Text(message))
            }
        }

        client.close()

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
                    CostsPage(navController = navController)
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