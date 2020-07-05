package com.awe.music.persistence.dto.response

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class AccountResponse @JsonCreator constructor(
        @field:JsonProperty("username")
        val username: String,
        @field:JsonProperty("password")
        val password: String,
        @field:JsonProperty("full_name")
        val fullName: String
)