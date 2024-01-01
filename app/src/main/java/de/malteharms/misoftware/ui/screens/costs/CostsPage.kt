package de.malteharms.misoftware.ui.screens.costs

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.malteharms.misoftware.models.COSTS
import de.malteharms.misoftware.models.CostEntry
import de.malteharms.misoftware.models.CostState
import de.malteharms.misoftware.models.CostsGroupContainer
import de.malteharms.misoftware.models.Screens
import de.malteharms.misoftware.ui.components.AppBar
import de.malteharms.misoftware.ui.components.cards.LARGE_FONT_SIZE
import de.malteharms.misoftware.ui.components.wrapper.CostsGroupElement
import de.malteharms.misoftware.ui.components.wrapper.CostsListElement
import de.malteharms.misoftware.ui.screens.costs.elements.Saldo
import de.malteharms.misoftware.ui.screens.costs.elements.TimelineSpacer
import de.malteharms.misoftware.utils.getAveragePerDayPerGroup
import de.malteharms.misoftware.utils.getMonthFromDate
import de.malteharms.misoftware.utils.getSumForEntry
import de.malteharms.misoftware.utils.getSampleDataSet
import de.malteharms.misoftware.utils.getSumForGroup
import de.malteharms.misoftware.utils.getYearFromDate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CostsPage(
    navController: NavController,
    state: CostState,
    addItemFunction: (item: CostEntry) -> Unit
) {
    val sampleData = getSampleDataSet()

    val padding = 20
    val selectedIndex by remember { mutableIntStateOf(0) }
    val maxScreenWidth = LocalConfiguration.current.screenWidthDp
    val rightSpaceWidth = (maxScreenWidth * 0.45)

    Scaffold (
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    addItemFunction(
                        CostEntry(
                            title = "Einkauf Edeka",
                            payedBy = "Malte",
                            amount = 2.0F,
                            timestamp = "01.01.2024"
                        )
                    )
                },
                text = { Text(text = "Neu") },
                icon = { Icon(Icons.Filled.Add, "") }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBar(
                    title = COSTS,
                    navController = navController
                )

                CostSummary(sampleData[selectedIndex])
                Spacer(modifier = Modifier.height(padding.dp))

                Box (modifier = Modifier
                    .width(rightSpaceWidth.dp)
                    .fillMaxHeight()
                ){
                    Column (
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ){

                        println(state.items)
                        state.items.forEach { item ->
                            CostsListElement(
                                title = item.title,
                                trailingNumber = "${item.amount}€"
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                    }
                }
            }
            // TODO #15 Missing floating button to filter the displayed items
            // https://github.com/malteharms/MISoftware/issues/15
        }
    }

}


@Composable
fun CostSummary(groupContainer: CostsGroupContainer) {
    val elevation = 5
    val roundedCorner = 20

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(roundedCorner.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(elevation.dp))
            .padding((roundedCorner / 2).dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(   // title
                text = "Zusammenfassung",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Row(    // values and graph
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Gesamt", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Text(text = getSumForGroup(groupContainer), fontSize = 10.sp)
                }
                // TODO #17 Saldo needs a graphical representation, not just text
                // https://github.com/malteharms/MISoftware/issues/17
                Saldo(groupContainer)
                Column (horizontalAlignment = Alignment.End) {
                    Text(text = "∅/Tag", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Text(text = getAveragePerDayPerGroup(groupContainer), fontSize = 10.sp)
                }
            }
        }
    }
}