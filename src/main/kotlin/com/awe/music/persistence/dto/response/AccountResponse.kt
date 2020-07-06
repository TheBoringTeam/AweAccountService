package com.awe.music.persistence.dto.response

import com.awe.music.persistence.domain.Account
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Class represents response object for create a new account action.
 */
class AccountResponse(account: Account) {

    @field:JsonProperty("username")
    var username: String = account.username

    @field:JsonProperty("full_name")
    var fullName: String = account.name

    @field:JsonProperty("account_uuid")
    var uuid: String = account.uuid.toString()

    @field:JsonProperty("email")
    var email: String = account.email

}