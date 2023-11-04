package de.malteharms.misoftware.models

import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Date

data class CostsGroupContainer(
    val title: String,
    val creationDate: Date,
    val entries: MutableList<CostsEntryContainer>
)

data class CostsEntryContainer(
    val title: String,
    val icon: ImageVector,
    val payedFrom: MutableMap<String, Float>,    // <name, amount>
    val date: Date,
    val label: MutableList<Label>
)
