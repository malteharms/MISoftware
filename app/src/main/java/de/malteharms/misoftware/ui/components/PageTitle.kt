package de.malteharms.misoftware.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PageTitle(
    title: String
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 60.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 20.dp)
        )
    }
}