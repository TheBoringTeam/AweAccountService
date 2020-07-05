package com.awe.music.persistence.dto.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class AccountCreateRequest @JsonCreator constructor(
        @field:JsonProperty("username")
        val username: String,

        @field:JsonProperty("password")
        val password: String,

        @field:JsonProperty("is_collective")
        val isCollective: Boolean,

        @field:JsonProperty("email")
        val email: String
)