package de.malteharms.misoftware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.malteharms.misoftware.ui.theme.MISoftwareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MISoftwareTheme {



            }
        }
    }
}
