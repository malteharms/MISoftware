package de.malteharms.misoftware.connection

import de.malteharms.misoftware.models.CostEntry
import io.ktor.client.HttpClient
import io.ktor.websocket.Frame
import io.ktor.websocket.WebSocketSession
import io.ktor.websocket.close
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WebsocketListener(
    private val client: HttpClient
): MessagingClient {

    private var session: WebSocketSession? = null
    override suspend fun sendCostEntry(item: CostEntry) {
        session?.outgoing?.send(
            Frame.Text("new_item#${Json.encodeToString(item)}")
        )
    }


    override suspend fun close() {
        session?.close()
        session = null
    }


}