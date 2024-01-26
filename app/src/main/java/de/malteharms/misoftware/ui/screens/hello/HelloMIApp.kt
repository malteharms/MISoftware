package de.malteharms.misoftware.ui.screens.hello

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.malteharms.misoftware.models.Screens


@Composable
fun HelloMIApp(
    navigator: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hi ✌\uD83C\uDFFD",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "",
                fontSize = 20.sp,
                modifier = Modifier.alpha(.3f)
            )
        }


        Column(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { navigator.navigate(Screens.LoginRoute.route) },
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .absolutePadding(bottom = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 255, green = 125, blue = 0),
                    contentColor = Color.White
                )
            ) {
                Text(text = "logge dich ein")
            }

            OutlinedButton(
                onClick = { navigator.navigate(Screens.RegisterRoute.route) },
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .absolutePadding(top = 5.dp)
            ) {
                Text(
                    text = "erstelle dir ein Account",
                    color = Color(red = 255, green = 125, blue = 0)
                )

            }
        }
    }
}




