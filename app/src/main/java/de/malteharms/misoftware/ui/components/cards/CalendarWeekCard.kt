package de.malteharms.misoftware.ui.components.cards

import androidx.compose.runtime.Composable
import de.malteharms.misoftware.CALENDAR_WEEK
import de.malteharms.misoftware.ui.components.SimpleCard

const val CALENDAR_WEEK = "Kalender\nWoche"

@Composable
fun CalendarWeekCard() {
    SimpleCard(
        title = CALENDAR_WEEK,
        value = getCurrentCalendarWeek()
    )
}

fun getCurrentCalendarWeek(): String {
    return "42"
}