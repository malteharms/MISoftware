package de.malteharms.misoftware.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.malteharms.misoftware.ui.components.AppBar

@Composable
fun Profile(
    navController: NavController
) {
    Box(modifier = Modifier.padding(20.dp)) {
        Column {
            AppBar(
                title = "Profil",
                navController = navController
            )
        }
    }
}