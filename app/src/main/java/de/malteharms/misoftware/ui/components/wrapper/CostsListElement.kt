package de.malteharms.misoftware.ui.components.wrapper

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CostsListElement(
    title: String,
    trailingNumber: String,
    onClick: () -> Unit
) {
    val textSize: Int = 12

    Box(
        modifier = Modifier
            .padding(2.dp)
            .clickable { onClick() }

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = textSize.sp, fontWeight = FontWeight.Light)
            Text(text = trailingNumber, fontSize = textSize.sp, fontWeight = FontWeight.Light)
        }
    }

}


@Preview
@Composable
fun CostListElementPreview() {
    CostsListElement(
        title = "Einkauf Edeka",
        trailingNumber = "2,03€",
        onClick = {  }
    )
}
