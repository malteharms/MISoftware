package de.malteharms.misoftware.ui.components.wrapper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CostsListElement(
    title: String,
    trailingNumber: String
) {
    val textSize: Int = 12

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = textSize.sp, fontWeight = FontWeight.Light)
        Text(text = trailingNumber, fontSize = textSize.sp, fontWeight = FontWeight.Light)
    }
}
