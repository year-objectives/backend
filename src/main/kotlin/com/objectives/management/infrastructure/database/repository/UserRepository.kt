package com.objectives.management.infrastructure.database.repository

import com.objectives.management.infrastructure.database.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserEntity, Long>  {

    fun findByUsername(username: String): UserEntity?
    fun existsByUsernameOrEmail(username: String, email: String): Boolean
    fun findByResourceId(userId: UUID): UserEntity
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
}