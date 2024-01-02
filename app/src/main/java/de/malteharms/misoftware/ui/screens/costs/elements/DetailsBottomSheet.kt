package de.malteharms.misoftware.ui.screens.costs.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.malteharms.misoftware.models.CostItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsBottomSheet(
    item: CostItem,
    onDismiss: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        // Sheet content
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ){
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = item.title)
                Text(text = item.payedBy)
                Text(text = "${item.amount}€")
                Text(text = item.timestamp)
            }
        }
    }
}

@Preview
@Composable
fun DetailsBottomSheetPreview() {
    DetailsBottomSheet(
        item = CostItem(
            title = "Einkauf Edeka",
            payedBy = "Malte",
            amount = 34.56F,
            timestamp = "01.01.2024"
        ),
        onDismiss = {  }
    )
}