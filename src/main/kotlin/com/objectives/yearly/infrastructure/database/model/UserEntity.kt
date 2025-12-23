package com.objectives.yearly.infrastructure.database.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import java.util.UUID

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
    @SequenceGenerator(name = "users_generator", sequenceName = "users_seq", allocationSize = 1)
    private val id: Long? = null,
    val resourceId: UUID = UUID.randomUUID(),
    var name: String,
    var username: String,
    var email: String,
    var password: String,
    val authorities: List<GrantedAuthority> = emptyList()) : AuditableEntity()