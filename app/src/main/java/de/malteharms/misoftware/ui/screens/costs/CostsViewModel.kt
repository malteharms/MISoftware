package de.malteharms.misoftware.ui.screens.costs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.malteharms.misoftware.models.CostResultWrapper
import de.malteharms.misoftware.connection.RealtimeMessagingClient
import de.malteharms.misoftware.models.CostsAddItemOutgoingMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.net.ConnectException

class CostsViewModel(
    private val client: RealtimeMessagingClient
): ViewModel() {

    val state = client
        .getSocketStream()
        .onStart { _isConnecting.value = true }
        .onEach { _isConnecting.value = false }
        .catch { t -> _showConnectionError.value = t is ConnectException }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), CostResultWrapper())


    private val _isConnecting = MutableStateFlow(false)
    val isConnecting = _isConnecting.asStateFlow()

    private val _showConnectionError = MutableStateFlow(false)
    val showConnectionError = _showConnectionError.asStateFlow()

    fun addItem(item: CostsAddItemOutgoingMessage) {
        viewModelScope.launch {
            client.sendAddItem(item)
        }
    }

}