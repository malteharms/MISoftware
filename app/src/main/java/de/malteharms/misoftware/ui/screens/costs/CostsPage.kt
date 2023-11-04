package de.malteharms.misoftware.ui.screens.costs

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
import androidx.compose.material3.MaterialTheme
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
import de.malteharms.misoftware.models.CostsGroupContainer
import de.malteharms.misoftware.ui.components.wrapper.CostsGroupElement
import de.malteharms.misoftware.ui.components.wrapper.CostsListElement
import de.malteharms.misoftware.ui.screens.costs.elements.Saldo
import de.malteharms.misoftware.utils.getAveragePerDayPerGroup
import de.malteharms.misoftware.utils.getSumForEntry
import de.malteharms.misoftware.utils.getSampleDataSet
import de.malteharms.misoftware.utils.getSumForGroup

@Composable
fun CostsPage() {
    val sampleData = getSampleDataSet()

    val padding = 20
    var selectedIndex by remember { mutableIntStateOf(0) }
    val maxScreenWidth = LocalConfiguration.current.screenWidthDp
    val leftSpaceWidth = (maxScreenWidth * 0.3)
    val rightSpaceWidth = (maxScreenWidth * 0.55)
    val maxScreenHeight = LocalConfiguration.current.screenHeightDp
    val splitHeight = (maxScreenHeight * 0.6)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {

            CostSummary(sampleData[selectedIndex])
            Spacer(modifier = Modifier.height(padding.dp))
            Row(    // Left / Right
                modifier = Modifier
                    .height(splitHeight.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box (modifier = Modifier
                    .width(leftSpaceWidth.dp)
                    .fillMaxHeight()){     // Left
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                    ) {
                        // TODO #16 Visualization for Year / Month / Week in costs group list
                        // https://github.com/malteharms/MISoftware/issues/16
                        sampleData.forEachIndexed { index, costGroup ->
                            CostsGroupElement(
                                title = costGroup.title,
                                isSelected = index == selectedIndex,
                                onClick = { selectedIndex = index }
                            )
                        }
                    }
                }

                Box (modifier = Modifier
                    .width(rightSpaceWidth.dp)
                    .fillMaxHeight()){    // Right
                    Column (
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ){

                        sampleData[selectedIndex].entries.forEach { entry ->
                            CostsListElement(
                                leadingIcon = entry.icon,
                                title = entry.title,
                                description = "Bezahlt von",
                                trailingNumber = getSumForEntry(entry.payedFrom)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                    }
                }
            }
        }
        // TODO #15 Missing floating button to filter the displayed items
        // https://github.com/malteharms/MISoftware/issues/15
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
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {    // values
                    Text(
                        text = "Gesamt: ${getSumForGroup(groupContainer)}",
                        fontSize = 12.sp)
                    Text(
                        text = "Ausgaben pro Tag: ${getAveragePerDayPerGroup(groupContainer)}",
                        fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Saldo(groupContainer)   // graph
            }
        }
    }
}