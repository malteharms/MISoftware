package de.malteharms.misoftware.models

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val uuid: String,
    val username: String,       // displayed name
    val password: String,       // SHA256 hash of the password
    val groups: List<String>    // list of groupId's for a specific account
)

@Serializable
data class Group(
    val id: String,             // identifier of a group
    val name: String,           // displayed name
    val member: List<String>    // list of uuid's
)
