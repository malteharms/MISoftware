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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import de.malteharms.misoftware.models.CostsGroupContainer
import de.malteharms.misoftware.ui.components.wrapper.CostsGroupElement
import de.malteharms.misoftware.ui.components.wrapper.CostsListElement

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
                                trailingNumber = getPaidSum(entry.payedFrom)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(padding.dp))
            CostSummary(sampleData[selectedIndex])
        }
    }
}


@Composable
fun CostSummary(entry: CostsGroupContainer) {
    val elevation = 5
    val roundedCorner = 20

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(roundedCorner.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(elevation.dp))
            .padding((roundedCorner / 2).dp)
    ) {
        Text(text = "Summary for ${entry.title}")
    }
}