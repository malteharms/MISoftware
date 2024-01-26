package de.malteharms.misoftware.connection

import de.malteharms.misoftware.models.CostResultWrapper
import de.malteharms.misoftware.models.CostsAddItemOutgoingMessage
import de.malteharms.misoftware.models.Register
import kotlinx.coroutines.flow.Flow

interface RealtimeMessagingClient {

    fun getSocketStream(): Flow<CostResultWrapper>
    suspend fun sendAddItem(item: CostsAddItemOutgoingMessage)
    suspend fun sendRegistrationRequest(account: Register)
    suspend fun close()


}