package de.malteharms.misoftware.ui.components.wrapper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

const val ELEVATION = 6
const val CARD_WIDTH_FROM_MAX = 0.6
const val BUTTON_WIDTH_FROM_MAX = 0.2
const val CARD_HEIGHT = 150
const val ITEM_PADDING = 15

const val CARD_PADDING = 3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppWrapper(
    preview: @Composable (navController: NavController) -> Unit,
    previewRoute: String,
    title: String,
    icon: ImageVector,
    magic: @Composable (navController: NavController) -> Unit,
    // magicRoute: String,
    navController: NavController
) {
    val maxScreenWidth = LocalConfiguration.current.screenWidthDp
    val cardWidth = (maxScreenWidth * CARD_WIDTH_FROM_MAX).dp
    val buttonWidth = (maxScreenWidth * BUTTON_WIDTH_FROM_MAX).dp

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(CARD_HEIGHT.dp)
            .padding(ITEM_PADDING.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = ELEVATION.dp),
            modifier = Modifier
                .size(width = cardWidth, height = CARD_HEIGHT.dp),
            onClick = {navController.navigate(previewRoute)}
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(CARD_PADDING.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        icon,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        title,
                        fontWeight = FontWeight.Bold
                    )
                }
                preview(navController)
            }
        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = ELEVATION.dp),
            modifier = Modifier
                .size(width = buttonWidth, height = CARD_HEIGHT.dp),
            //onClick = { onclickMagic(navController) }
        ){
            magic(navController)
        }
    }
}