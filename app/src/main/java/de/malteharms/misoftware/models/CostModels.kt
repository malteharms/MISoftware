package de.malteharms.misoftware.models

import kotlinx.serialization.Serializable


@Serializable
data class CostEntry(
    val title: String,
    val payedBy: String,
    val amount: Float,
    val timestamp: String
)
