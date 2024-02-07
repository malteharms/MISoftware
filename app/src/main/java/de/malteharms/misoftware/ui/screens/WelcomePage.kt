package de.malteharms.misoftware.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.malteharms.misoftware.domain.SharedPreferencesManager

@Composable
fun WelcomePage(
    navController: NavController,
    spm: SharedPreferencesManager
) {

    Log.i("Welcome", "Hello from welcome Screen")

    Box (
        modifier = Modifier.fillMaxSize(),
    ){
        Text(text = "WelcomePage", fontSize = 40.sp, color = Color.Black)
    }

}