package com.awe.music.utils.builders

import com.awe.music.persistence.dto.response.AweResponse
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Builder responsible for creating a response object to edge services.
 */
class ResponseBuilder {
    private var isSuccessful: Boolean = true
    private var value: String = ""

    private val _objectMapper = ObjectMapper()

    fun ok() = apply {
        isSuccessful = true
    }

    fun error() = apply {
        isSuccessful = false
    }

    fun <T> value(content: T) = apply {
        value = _objectMapper.writeValueAsString(content)
    }

    fun get(): String {
        return _objectMapper.writeValueAsString(AweResponse(value, isSuccessful))
    }
}