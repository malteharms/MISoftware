package de.malteharms.misoftware.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.malteharms.misoftware.data.models.NestedRoutes
import de.malteharms.misoftware.domain.SharedPreferencesManager

@Composable
fun HomePage(
    navController: NavController,
    spm: SharedPreferencesManager
) {

    // navigate to the welcome screen when the user
    // has no account saved yet
    if (!spm.contains("uuid")) {
        navController.navigate(NestedRoutes.AuthRoute.route) {
            popUpTo(NestedRoutes.MainRoute.route) {
                inclusive = true
            }
        }
    }

    Box (
        modifier = Modifier.fillMaxSize(),
    ){
        Text(text = "HomePage", fontSize = 40.sp)
    }

}