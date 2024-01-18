package de.malteharms.misoftware.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PageTitle(
    title: String
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 50.dp)
        )
    }
}