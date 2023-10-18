package de.malteharms.misoftware.ui.components.cards

import androidx.compose.runtime.Composable
import de.malteharms.misoftware.CALENDAR_WEEK
import de.malteharms.misoftware.ui.components.SimpleCard
import java.util.Calendar

const val CALENDAR_WEEK = "Kalender\nWoche"

@Composable
fun CalendarWeekCard() {
    SimpleCard(
        title = CALENDAR_WEEK,
        value = getCurrentCalendarWeek()
    )
}

fun getCurrentCalendarWeek(): String {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.WEEK_OF_YEAR).toString()
}