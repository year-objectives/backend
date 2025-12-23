package com.objectives.yearly.infrastructure.database.repository

import com.objectives.yearly.infrastructure.database.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository: JpaRepository<UserEntity, Long>  {

    fun findByUsername(username: String): UserEntity?
    fun existsByUsernameOrEmail(username: String, email: String): Boolean
    fun findByResourceId(userId: UUID): UserEntity
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
}