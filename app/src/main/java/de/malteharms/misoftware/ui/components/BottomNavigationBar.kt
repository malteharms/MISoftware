package de.malteharms.misoftware.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import de.malteharms.misoftware.models.BottomNavigationItem

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {

    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    NavigationBar {
        //getting the list of bottom navigation items for our data class
        BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->

            //iterating all items with their respective indexes
            NavigationBarItem(
                /*If our current index of the list of items
                 *is equal to navigationSelectedItem then simply
                 *The selected item is active in overView this
                 *is used to know the selected item
                 */
                selected = index == navigationSelectedItem,

                //Label is used to bottom navigation labels like Home, Search
                label = {
                    Text(navigationItem.label)
                },

                // Icon is used to display the icons of the bottom Navigation Bar
                icon = {
                    Icon(
                        navigationItem.icon,
                        contentDescription = navigationItem.label)
                },
                // used to handle click events of navigation items
                onClick = {
                    navigationSelectedItem = index
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}