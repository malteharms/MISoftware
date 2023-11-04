package de.malteharms.misoftware.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary

        ),
        title = {
            Text(
                text = "I&M",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            // TODO #3 Show edit symbol only on home screen
            // https://github.com/malteharms/MISoftware/issues/3
            IconButton(onClick = {
                // TODO #12 Button Edit in AppBar has no functionality
                // https://github.com/malteharms/MISoftware/issues/12
            }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit view"
                )
            }
            IconButton(onClick = {
                // TODO #13 Button Account in AppBar has no functionality
                // https://github.com/malteharms/MISoftware/issues/13
            }) {
                Icon(
                  imageVector = Icons.Filled.AccountCircle,
                  contentDescription = "Account"
              )
            }
        }
    )
}