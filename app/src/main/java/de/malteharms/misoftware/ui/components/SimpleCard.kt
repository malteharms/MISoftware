package de.malteharms.misoftware.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val ELEVATION = 6.dp
val PADDING = 5.dp

var CARD_WIDTH = 140.dp
val CARD_WIDTH_FROM_MAX = 0.4

val CARD_HEIGHT = 100.dp

val SMALL_FONT_SIZE = 12.sp
val LARGE_FONT_SIZE = 36.sp


@Composable
fun SimpleCard(
    title: String,
    value: String,
) {

    val maxScreenWidth = LocalConfiguration.current.screenWidthDp
    CARD_WIDTH = (maxScreenWidth.toInt() * CARD_WIDTH_FROM_MAX).dp

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = ELEVATION
        ),
        modifier = Modifier
            .size(width = CARD_WIDTH, height = CARD_HEIGHT)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize().padding(PADDING),

            ){
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontSize = SMALL_FONT_SIZE,
            )
            Text(
                text = value,
                textAlign = TextAlign.Center,
                fontSize = LARGE_FONT_SIZE,
            )
        }
    }
}