package de.malteharms.misoftware.connection

import de.malteharms.misoftware.models.CostEntry
import de.malteharms.misoftware.models.CostState
import kotlinx.coroutines.flow.Flow

interface RealtimeMessagingClient {

    fun getCostStateStream(): Flow<CostState>
    suspend fun sendAddItem(item: CostEntry)
    suspend fun close()

}