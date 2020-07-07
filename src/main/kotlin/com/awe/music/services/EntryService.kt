package com.awe.music.services

import com.awe.music.persistence.dto.request.AccountCreateRequest
import com.awe.music.utils.builders.ResponseBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Service

/**
 * Service responsible for handling all requests from edge service.
 */
@Service
class EntryService @Autowired constructor(
        private val _accountService: AccountService
) {
    private val _logger = Logger.getLogger(EntryService::class.java)

    private val _objectMapper = ObjectMapper()

    /**
     * Creates an account in database and returns it to edge service.
     * @param json AccountCreateRequest object in string representation
     * @return AweResponse object that contains Account entity
     */
    @KafkaListener(topicPattern = "createAccountTopic", groupId = "alpha-service-group")
    @SendTo
    fun createAccountRequest(json: String): String {
        _logger.info("Received request for creating user")
        val request = _objectMapper.readValue(json, AccountCreateRequest::class.java)
        _logger.info("Sending response...")
        return ResponseBuilder().ok().value(_accountService.save(request)).get()
    }

    /**
     * Finds account entity by username and returns it.
     * @param username String contains account username for query
     * @return AweResponse object that contains Account entity
     */
    @KafkaListener(topicPattern = "findAccountByUsernameTopic", groupId = "accountServiceGroup")
    @SendTo
    fun findAccountByUsername(username: String): String {
        _logger.info("Received request for finding an account by username: $username")
        return ResponseBuilder().ok().value(_accountService.findByUsername(username)).get()
    }

    /**
     * Check whether account exists with provided username
     * @param username String contains account username
     * @return AweResponse object that contains Boolean
     */
    @KafkaListener(topicPattern = "existsAccountByUsernameTopic", groupId = "accountServiceGroup")
    @SendTo
    fun existsByUsername(username: String): String {
        _logger.info("Received request for checking account exists by username: $username")
        return ResponseBuilder().ok().value(_accountService.existsByUsername(username)).get()
    }
}