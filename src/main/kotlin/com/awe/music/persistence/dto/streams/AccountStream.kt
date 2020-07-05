package com.awe.music.persistence.dto.streams

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class AccountStream @JsonCreator constructor(
        @JsonProperty("username")
        var username: String,
        @JsonProperty("password")
        var password: String,
        @JsonProperty("email")
        var email: String,
        @JsonProperty("is_collective")
        var isCollective: Boolean
)