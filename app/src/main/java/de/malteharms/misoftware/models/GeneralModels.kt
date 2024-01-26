package de.malteharms.misoftware.models

import kotlinx.serialization.Serializable

enum class MessageType {
    REGISTER,
    LOGIN,
    COST_ADD_ITEM,
    COST_GET_ITEMS,
    ERROR
}

@Serializable
data class CostsAddItemOutgoingMessage(
    val type: MessageType,
    val data: CostItem
)

@Serializable
data class Register(
    val username: String,
    val email: String,
    val passwordHash: String
)
