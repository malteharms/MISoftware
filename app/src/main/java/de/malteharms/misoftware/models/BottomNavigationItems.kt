package de.malteharms.misoftware.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

const val HOME = "Home"
const val FUNCTIONS = "Apps"
const val STATISTIC = "Statistiken"
const val SETTINGS = "Einstllungen"


//initializing the data class with default parameters
data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {

    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = HOME,
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = FUNCTIONS,
                icon = Icons.Filled.List,
                route = Screens.Functions.route
            ),
            BottomNavigationItem(
                label = STATISTIC,
                icon = Icons.Filled.Home,
                route = Screens.Statistic.route
            ),
            BottomNavigationItem(
                label = SETTINGS,
                icon = Icons.Filled.Settings,
                route = Screens.Settings.route
            ),
        )
    }
}