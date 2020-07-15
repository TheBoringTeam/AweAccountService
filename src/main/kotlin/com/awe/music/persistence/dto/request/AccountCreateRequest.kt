package com.awe.music.persistence.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

class AccountCreateRequest(
        @JsonProperty("username")
        val username: String,

        @JsonProperty("password")
        val password: String,

        @JsonProperty("is_collective")
        val isCollective: Boolean,

        @JsonProperty("email")
        val email: String
) {}