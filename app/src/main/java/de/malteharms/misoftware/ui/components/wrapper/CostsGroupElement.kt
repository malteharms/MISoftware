package de.malteharms.misoftware.ui.components.wrapper

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CostsGroupElement(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val paddingLeft = 10
    val boxHeight = 30

    val backgroundColor: Color = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.background
    }

    Box (
        modifier = Modifier
            .width(100.dp)
            .height(boxHeight.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .padding(horizontal = paddingLeft.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
        )
    }
}