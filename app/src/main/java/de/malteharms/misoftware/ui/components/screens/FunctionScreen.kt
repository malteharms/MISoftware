package de.malteharms.misoftware.ui.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import de.malteharms.misoftware.ui.components.screens.costs.CostsPreview
import de.malteharms.misoftware.ui.components.wrapper.AppWrapper
import de.malteharms.misoftware.ui.theme.MISoftwareTheme

@Composable
fun FunctionScreen(navController: NavController) {
    MISoftwareTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                AppWrapper(
                    preview = { Text("Kalender") },
                    title = "Kalender",
                    icon = Icons.Default.Build,
                    magic = { Text(text = "magic")},
                    navController = navController
                )
                AppWrapper(
                    preview = { CostsPreview(navController = navController) },
                    title = "Costs",
                    icon = Icons.Default.Build,
                    magic = { Text(text = "magic")},
                    navController = navController
                )
                AppWrapper(
                    preview = { Text("Shopping") },
                    title = "Shopping",
                    icon = Icons.Default.ShoppingCart,
                    magic = { Text(text = "magic")},
                    navController = navController
                )
                AppWrapper(
                    preview = { Text("ToDo") },
                    title = "ToDo",
                    icon = Icons.Default.Build,
                    magic = { Text(text = "magic")},
                    navController = navController
                )
            }
        }
    }
}