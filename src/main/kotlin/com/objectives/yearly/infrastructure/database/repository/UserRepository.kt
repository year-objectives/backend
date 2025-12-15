package com.objectives.yearly.infrastructure.database.repository

import com.objectives.yearly.infrastructure.database.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Long>  {

    fun findByUsername(username: String): UserEntity?
    fun existsByUsernameOrEmail(username: String, email: String): Boolean
}