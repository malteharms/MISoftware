package de.malteharms.misoftware.utils

import de.malteharms.misoftware.models.CostItem
import java.util.Calendar
import kotlin.math.roundToInt


fun sumPayments(state: List<CostItem>): Float {
    var sum: Float = 0F
    state.forEach { item ->
        sum += item.amount
    }

    // Round up a float or a double with 2 decimal places
    return ((sum * 100.0).roundToInt() / 100.0).toFloat()
}


fun calculateAverage(state: List<CostItem>): Float {
    val currentTime = Calendar.getInstance().time
    val parts = currentTime.toString().split(" ")
    val currentDay = parts[2].toInt()

    val average = sumPayments(state) / currentDay

    return ((average * 100.0).roundToInt() / 100.0).toFloat()
}

fun emptyCostItem(): CostItem {
    return CostItem(
        title = "",
        groupId = "",
        payedBy = "",
        createdBy = "",
        amount = 0F,
        timestamp = 0
    )
}