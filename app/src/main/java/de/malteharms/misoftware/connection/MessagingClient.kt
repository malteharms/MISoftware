package de.malteharms.misoftware.connection

import de.malteharms.misoftware.models.CostEntry
import kotlinx.coroutines.flow.Flow

interface MessagingClient {

    // fun getCostEntryStream(): Flow<CostEntry>
    suspend fun sendCostEntry(item: CostEntry)
    suspend fun close()

}