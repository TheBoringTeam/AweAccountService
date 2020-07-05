package com.awe.music.services

import com.awe.music.persistence.domain.Account
import com.awe.music.persistence.dto.request.AccountCreateRequest
import com.awe.music.repositories.AccountRepository
import com.awe.music.utils.exceptions.ResourceNotFoundException
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 * Service responsible for account business logic
 */
@Service
class AccountService @Autowired constructor(private val _accountRepository: AccountRepository) {

    private val _logger = Logger.getLogger(AccountService::class.java)

    fun findByUsername(username: String): Account {
        return _accountRepository.findByUsername(username).orElseThrow { ResourceNotFoundException("There is no user with provided username") }
    }

    fun existsByUsername(username: String): Boolean {
        return _accountRepository.existsByUsername(username)
    }

    fun findByUUID(uuid: UUID): Account {
        return _accountRepository.findByUuid(uuid).orElseThrow { ResourceNotFoundException("There is no user with provided uuid") }
    }

    fun save(cr: AccountCreateRequest): Account {
        _logger.info("Saving user with username: ${cr.username}")
        return _accountRepository.save(Account(cr.username, cr.password, cr.email, cr.username, cr.isCollective))
    }
}