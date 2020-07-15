package com.awe.music.repositories

import com.awe.music.persistence.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Repository responsible for Account entity ("awesome_account" in db) management.
 */
@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUsername(username: String): Optional<Account>

    fun findByUuid(uuid: UUID): Optional<Account>

    fun existsByUsername(username: String): Boolean

    fun findByEmail(email: String): Optional<Account>
}