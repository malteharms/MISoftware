package de.malteharms.misoftware.ui.screens.costs.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimelineSpacer(key: String) {

    val bottomPadding = 2
    val startPadding = 5

    Text(text = key, fontSize = 12.sp, fontWeight = FontWeight.Light,
        modifier = Modifier.padding(
            bottom = bottomPadding.dp,
            start = startPadding.dp))

}