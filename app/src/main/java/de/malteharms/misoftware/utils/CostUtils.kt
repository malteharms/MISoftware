package de.malteharms.misoftware.utils

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

fun getSumForEntry(payedFrom: MutableMap<String, Float>): String {
    var sum = 0F
    payedFrom.forEach { (_, value) ->
        sum += value
    }
    return "${String.format("%.2f", sum)}€"
}

fun getSum(group: CostsGroupContainer): Float {
    var overallCost = 0F
    group.entries.forEach { element ->
        var currentCost = 0F
        element.payedFrom.forEach { (_, value) ->
            currentCost += value
        }
        overallCost += currentCost
    }
    return overallCost
}

fun getSumForGroup(group: CostsGroupContainer): String {
    return "${String.format("%.2f", getSum(group))}€"
}

fun getAveragePerDayPerGroup(group: CostsGroupContainer): String {
    val currentTime = Calendar.getInstance().time
    val parts = currentTime.toString().split(" ")
    val currentDay = parts[2].toInt()

    return "${String.format("%.2f", getSum(group) / currentDay)}€"
}

fun getExpensesByName(group: CostsGroupContainer): MutableMap<String, Float> {
    val costsByName: MutableMap<String, Float> = mutableMapOf() // declare map
    group.member.forEach { name -> costsByName[name] = 0F }     // initialize map

    group.entries.forEach { element ->
        element.payedFrom.forEach { (name, amount) ->
            if (costsByName[name] == null) {
                costsByName[name] = 0F
            }
            costsByName[name] = costsByName[name]!! + amount
        }
    }
    return costsByName
}

fun getSampleDataSet(): List<CostsGroupContainer> {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.time

    return listOf(
        CostsGroupContainer(
            title = "BS",
            creationDate = currentDate,
            member = listOf("Malte", "Ina"),
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
            member = listOf("Malte", "Ina"),
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
                        "Ina" to 1.toFloat()),
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