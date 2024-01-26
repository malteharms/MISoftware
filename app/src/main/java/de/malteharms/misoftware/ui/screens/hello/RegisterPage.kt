package de.malteharms.misoftware.ui.screens.hello

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.malteharms.misoftware.models.Register
import de.malteharms.misoftware.ui.components.input.BasicInputField

@Composable
fun RegisterPage(
    registerFunction: (item: Register) -> Unit
) {

    var loading by remember { mutableStateOf(false) }

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.padding(20.dp),
        floatingActionButton = {
            OutlinedButton(
                onClick = {
                    if (loading) { return@OutlinedButton }

                    loading = true
                    registerFunction(
                        Register(
                            username = username,
                            email = email,
                            passwordHash = password
                        )
                    )
                },
                Modifier.height(50.dp)
            ) {
                Text(
                    text = "registrieren",
                    color = Color(red = 255, green = 125, blue = 0)
                )

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (loading) {
                LinearProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Tell us something about yourself",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 50.dp),
                    style = TextStyle(
                        lineHeight = 50.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BasicInputField(
                    mainLabel = "Your Name",
                    placeholder = "",
                    icon = Icons.Default.Face,
                    isPassword = false
                ) { output -> username = output }

                Spacer(modifier = Modifier.height(20.dp))

                BasicInputField(
                    mainLabel = "Your Mail",
                    placeholder = "",
                    icon = Icons.Default.MailOutline,
                    isPassword = false
                ) { output -> email = output }

                Spacer(modifier = Modifier.height(20.dp))

                BasicInputField(
                    mainLabel = "Password",
                    placeholder = "",
                    icon = Icons.Default.Lock,
                    isPassword = true
                ) { output -> password = output }

            }
        }
    }

}

@Preview
@Composable
fun PreviewRegisterScreen() {
    // RegisterPage()
}