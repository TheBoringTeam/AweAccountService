package com.awe.music.persistence.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "account_role")
class AccountRole(
        @ManyToOne
        @JoinColumn(name = "account_uuid")
        var account: Account,

        @ManyToOne
        @JoinColumn(name = "role_id")
        var role: Role,

        @Column(name = "expiry_at", nullable = true)
        var expiryAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_role_id")
    val id: Long = 0

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
}