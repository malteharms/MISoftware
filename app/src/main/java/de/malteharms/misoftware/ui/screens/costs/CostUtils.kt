package de.malteharms.misoftware.ui.screens.costs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import de.malteharms.misoftware.models.CostsEntryContainer
import de.malteharms.misoftware.models.CostsGroupContainer
import de.malteharms.misoftware.models.Label
import java.util.Calendar

fun getPaidSum(payedFrom: MutableMap<String, Float>): String {
    var sum: Float = 0F
    payedFrom.forEach { (_, value) ->
        sum += value
    }
    return sum.toString() + "€"
}

fun getSampleDataSet(): List<CostsGroupContainer> {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.time

    return listOf(
        CostsGroupContainer(
            title = "BS",
            creationDate = currentDate,
            entries = mutableListOf(
                CostsEntryContainer(
                    title = "Einkauf Rewe",
                    icon = Icons.Filled.Menu,
                    payedFrom = mutableMapOf(
                        "Malte" to 4.34.toFloat(),
                        "Ina" to 0.0.toFloat()),
                    date = currentDate,
                    label = mutableListOf(
                        Label(name = "Einkauf", color = Color.Blue),
                        Label(name = "Woche", color = Color.Red)
                    )
                ),
                CostsEntryContainer(
                    title = "Einkauf Edeka",
                    icon = Icons.Filled.Build,
                    payedFrom = mutableMapOf(
                        "Malte" to 27.toFloat(),
                        "Ina" to 0.toFloat()),
                    date = currentDate,
                    label = mutableListOf(
                        Label(name = "Einkauf", color = Color.Blue),
                        Label(name = "Woche", color = Color.Red)
                    )
                ),
            )
        ),

        CostsGroupContainer(
            title = "Malte",
            creationDate = currentDate,
            entries = mutableListOf(
                CostsEntryContainer(
                    title = "Essenskarte aufgeladen",
                    icon = Icons.Filled.ArrowBack,
                    payedFrom = mutableMapOf(
                        "Malte" to 50.toFloat(),
                        "Ina" to 0.0.toFloat()),
                    date = currentDate,
                    label = mutableListOf(
                        Label(name = "Einkauf", color = Color.Blue),
                        Label(name = "Woche", color = Color.Red)
                    )
                ),
                CostsEntryContainer(
                    title = "Job Ticket",
                    icon = Icons.Filled.AddCircle,
                    payedFrom = mutableMapOf(
                        "Malte" to 36.toFloat(),
                        "Ina" to 0.toFloat()),
                    date = currentDate,
                    label = mutableListOf(
                        Label(name = "Einkauf", color = Color.Blue),
                        Label(name = "Woche", color = Color.Red)
                    )
                ),
            )
        ),
    )
}