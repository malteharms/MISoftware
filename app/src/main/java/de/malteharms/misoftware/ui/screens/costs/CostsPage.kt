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
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import de.malteharms.misoftware.ui.components.wrapper.CostsGroupElement
import de.malteharms.misoftware.ui.components.wrapper.CostsListElement

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CostsPage() {

    val padding = 15
    val elevation = 5
    val roundedCorner = 20

    val maxScreenWidth = LocalConfiguration.current.screenWidthDp
    val splitWidth = (maxScreenWidth * 0.45)

    val maxScreenHeight = LocalConfiguration.current.screenHeightDp
    val splitHeight = (maxScreenHeight * 0.7)

    val listModifier = Modifier
        .width(splitWidth.dp)
        .fillMaxHeight()
        //.background(MaterialTheme.colorScheme.surfaceColorAtElevation(elevation.dp))

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
                Box (modifier = listModifier){  // Left
                    Column (
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ){
                        CostsGroupElement(false)
                        CostsGroupElement(true)
                        CostsGroupElement(false)
                        CostsGroupElement(false)
                    }
                }

                Box (modifier = listModifier){
                    Column (
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ){
                        for (i in 0..100){
                            CostsListElement(
                                leadingIcon = Icons.Default.ShoppingCart,
                                title = "Title",
                                description = "Desc",
                                trailingNumber = "500€"
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(padding.dp))
            Box(    // Bottom
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(roundedCorner.dp))
                    .background(MaterialTheme.colorScheme.surfaceColorAtElevation(elevation.dp))
                    .padding((roundedCorner / 2).dp)
            ) {
                Text(text = "diff")
            }
        }
    }
}