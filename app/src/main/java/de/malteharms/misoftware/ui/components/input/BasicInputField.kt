package de.malteharms.misoftware.ui.components.input

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BasicInputField(
    mainLabel: String,
    placeholder: String,
    icon: ImageVector,
    isPassword: Boolean,
    param: (String) -> Unit
) {
    var value by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    if (isPassword) {
        TextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = ""
                )
            },
            label = { Text(text = mainLabel) },
            placeholder = { Text(text = placeholder) },

            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Outlined.Lock else Icons.Outlined.Info,
                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
        )
    } else {
        TextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = ""
                )
            },
            label = { Text(text = mainLabel) },
            placeholder = { Text(text = placeholder) },
        )
    }
}



@Preview
@Composable
fun PreviewBasicInputField() {
    var username = ""
    BasicInputField(
        mainLabel = "Username",
        placeholder = "Type your username here",
        icon = Icons.Default.Person,
        isPassword = false
    ) { output -> username = output }
}
