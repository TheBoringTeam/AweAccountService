package com.awe.music.persistence.dto.response

import com.awe.music.persistence.domain.Account
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Class represents response object for create a new account action.
 */
class AccountResponse @JsonCreator constructor(account: Account) {
    @field:JsonProperty("username")
    var username = account.username

    @field:JsonProperty("email")
    var email = account.email

    @field:JsonProperty("full_name")
    var name = account.name

    @field:JsonProperty("is_collective")
    var isCollective = account.isCollective

    @field:JsonProperty("uuid")
    var uuid: String = account.uuid.toString()

    @field:JsonProperty("followers")
    var followers = account.followerCounter

    @field:JsonProperty("is_activated")
    var isActivated = account.isActivated

    @field:JsonProperty("is_verified")
    var isVerified = account.isVerified

    @field:JsonProperty("is_blocked")
    var isBlocked = account.isBlocked

    @field:JsonProperty("permissions")
    var permissions = account.getPermissions()

}