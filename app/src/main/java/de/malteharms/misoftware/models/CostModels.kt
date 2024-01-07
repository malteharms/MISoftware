package de.malteharms.misoftware.models

import kotlinx.serialization.Serializable


@Serializable
data class CostResultWrapper(
    val items: List<CostItem> = listOf(),
    val collectedTimestamp: Long = 0
)


@Serializable
data class CostItem(
    val title: String,              // title of payment
    val groupId: String,            // reference to group
    val payedBy: String,            // uuid of person who paid
    val createdBy: String,          // uuid of person who created this item
    val amount: Float,              // cost amount
    val timestamp: Long             // date
)
