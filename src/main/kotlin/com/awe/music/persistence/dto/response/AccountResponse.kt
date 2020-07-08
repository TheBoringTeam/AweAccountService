package com.awe.music.persistence.dto.response

import com.awe.music.persistence.domain.Account
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Class represents response object for create a new account action.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AccountResponse constructor(account: Account) {
    @field:JsonProperty("username")
    val username = account.username

    @field:JsonProperty("email")
    val email = account.email

    @field:JsonProperty("full_name")
    val name = account.name

    @field:JsonProperty("is_collective")
    val isCollective = account.isCollective

    @field:JsonProperty("uuid")
    val uuid: String = account.uuid.toString()

    @field:JsonProperty("followers")
    val followers = account.followerCounter

    @field:JsonProperty("is_activated")
    val isActivated = account.isActivated

    @field:JsonProperty("is_verified")
    val isVerified = account.isVerified

    @field:JsonProperty("is_blocked")
    val isBlocked = account.isBlocked

    @field:JsonProperty("permissions")
    val permissions = account.getPermissions()

}