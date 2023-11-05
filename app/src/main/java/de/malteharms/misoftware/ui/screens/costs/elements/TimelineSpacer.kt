package de.malteharms.misoftware.ui.screens.costs.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimelineSpacer(key: String) {

    val bottomPadding = 2
    val topPadding = 13
    val startPadding = 5

    Text(text = key, fontSize = 12.sp,
        modifier = Modifier.padding(
            bottom = bottomPadding.dp,
            top = topPadding.dp,
            start = startPadding.dp))

}