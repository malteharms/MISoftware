package de.malteharms.misoftware.connection

import de.malteharms.misoftware.models.CostResultWrapper
import de.malteharms.misoftware.models.CostsAddItemOutgoingMessage
import kotlinx.coroutines.flow.Flow

interface RealtimeMessagingClient {

    fun getSocketStream(): Flow<CostResultWrapper>
    suspend fun sendAddItem(item: CostsAddItemOutgoingMessage)
    suspend fun close()

}