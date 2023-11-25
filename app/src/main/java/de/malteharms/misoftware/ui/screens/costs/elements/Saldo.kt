package de.malteharms.misoftware.ui.screens.costs.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import de.malteharms.misoftware.models.CostsGroupContainer
import de.malteharms.misoftware.utils.getExpensesByName

@Composable
fun Saldo(groupContainer: CostsGroupContainer) {
    val default = -1F

    val expenses: MutableMap<String, Float> = getExpensesByName(groupContainer)
    var lowestExpensesName: String = ""
    var lowestExpensesValue: Float = default

    expenses.forEach { (name, amount) ->
        if (lowestExpensesValue == default || lowestExpensesValue > amount) {
            lowestExpensesValue = amount
            lowestExpensesName = name
        }
    }

    Text(
        text = "$lowestExpensesName liegt hinten (Ausgaben: $lowestExpensesValue)",
        fontSize = 10.sp
    )
}