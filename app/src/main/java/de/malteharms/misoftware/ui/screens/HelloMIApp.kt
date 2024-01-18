package de.malteharms.misoftware.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.malteharms.misoftware.ui.components.PageTitle


enum class State {
    LOGIN,
    REGISTER
}

@Composable
fun HelloMIApp (
    navigator: NavController
){
    val initialState: State = State.REGISTER
    var currentState by remember { mutableStateOf(initialState) }


    // Variables based on the state
    val title: String by produceState(initialValue = "Register") {
        value = when (currentState) {
            State.LOGIN -> "Login"
            State.REGISTER -> "Register"
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
            ){
                PageTitle(title = title)
                LoginForms()
            }
        }
    }
}


@Composable
fun LoginForms() {

}