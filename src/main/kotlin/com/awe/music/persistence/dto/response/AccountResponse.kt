package com.awe.music.persistence.dto.response

import com.awe.music.persistence.domain.Account
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Class represents response object for create a new account action.
 */

class AccountResponse @JsonIgnore constructor(account: Account) {
    @field:JsonProperty("username")
    val username = account.username

    @field:JsonProperty("password")
    val password = account.password

    @field:JsonProperty("email")
    val email = account.email

    @field:JsonProperty("full_name")
    val name = account.name

    @get:JsonProperty("is_collective")
    val isCollective = account.isCollective

    @field:JsonProperty("uuid")
    val uuid: String = account.uuid.toString()

    @field:JsonProperty("followers")
    val followers = account.followerCounter

    @get:JsonProperty("is_activated")
    val isActivated = account.isActivated

    @get:JsonProperty("is_verified")
    val isVerified = account.isVerified

    @get:JsonProperty("is_blocked")
    val isBlocked = account.isBlocked

    @field:JsonProperty("permissions")
    val permissions = account.getPermissions()
}