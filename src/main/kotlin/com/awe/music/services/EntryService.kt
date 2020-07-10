package com.awe.music.services

import com.awe.music.persistence.dto.request.AccountCreateRequest
import com.awe.music.persistence.dto.response.AccountResponse
import com.awe.music.utils.builders.ResponseBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Service
import java.util.*

/**
 * Service responsible for handling all requests from edge service.
 */
@Service
class EntryService @Autowired constructor(
        private val _accountService: AccountService
) {
    private val _log = Logger.getLogger(EntryService::class.java)

    private val _objectMapper = ObjectMapper()

    /**
     * Creates an account in database and returns it to edge service.
     * @param json AccountCreateRequest object in string representation
     * @return AweResponse object that contains Account entity
     */
    @KafkaListener(topicPattern = "createAccountTopic", groupId = "alpha-service-group")
    @SendTo
    fun createAccountRequest(json: String): String {
        _log.info("Received request for creating user")
        val request = _objectMapper.readValue(json, AccountCreateRequest::class.java)
        _log.info("Sending response...")
        return ResponseBuilder().ok().value(AccountResponse(_accountService.save(request))).get()
    }

    /**
     * Finds account entity by username and returns it.
     * @param username String contains account username for query
     * @return AweResponse object that contains Account entity
     */
    @KafkaListener(topicPattern = "findAccountByUsernameTopic", groupId = "alpha-service-group")
    @SendTo
    fun findAccountByUsername(username: String): String {
        _log.info("Received request for finding an account by username: $username")
        return ResponseBuilder().ok().value(AccountResponse(_accountService.findByUsername(username))).get()
    }

    /**
     * Finds account entity by email and returns it.
     * @param email String contains account email
     * @return AweResponse object contains Account entity
     */
    @KafkaListener(topicPattern = "findAccountByEmailTopic", groupId = "alpha-service-group")
    @SendTo
    fun findAccountByEmail(email: String): String {
        _log.info("Received request for finding an account by email: $email")
        return ResponseBuilder().ok().value(AccountResponse(_accountService.findByEmail(email))).get()
    }

    /**
     * Check whether account exists with provided username
     * @param username String contains account username
     * @return AweResponse object that contains Boolean
     */
    @KafkaListener(topicPattern = "existsAccountByUsernameTopic", groupId = "alpha-service-group")
    @SendTo
    fun existsByUsername(username: String): String {
        _log.info("Received request for checking account exists by username: $username")
        return ResponseBuilder().ok().value(_accountService.existsByUsername(username)).get()
    }

    @KafkaListener(topicPattern = "findAccountByUUIDTopic", groupId = "alpha-service-group")
    @SendTo
    fun findAccountByUUID(uuid: String): String {
        _log.info("Received request for finding account by uuid: $uuid")
        return ResponseBuilder().ok().value(_accountService.findByUUID(UUID.fromString(uuid))).get()
    }
}