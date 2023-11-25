package de.malteharms.misoftware.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.malteharms.misoftware.ui.components.cards.LARGE_FONT_SIZE

@Composable
fun AppBar(
    title: String,
    navController: NavController
) {
    if (arrayOf("Profil").contains(title)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Filled.ArrowBack,
                "",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(30.dp)
                    .clickable { navController.popBackStack() })

            Text(
                text = title,
                fontSize = LARGE_FONT_SIZE,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .align(Alignment.Center)
            )
        }
    } else {
        Box(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Filled.AccountCircle,
                "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(30.dp)
                    .clickable { navController.navigate("profile_route") })

            Text(
                text = title,
                fontSize = LARGE_FONT_SIZE,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .align(Alignment.Center)
            )
        }
    }
}