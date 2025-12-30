package com.objectives.management.domain.mapper

import com.objectives.management.api.dto.requests.auth.UserRegisterDto
import com.objectives.management.api.dto.responses.UserResponseDto
import com.objectives.management.domain.mapper.utils.ApiToModel
import com.objectives.management.domain.mapper.utils.ModelToApi
import com.objectives.management.infrastructure.database.model.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(private val passwordEncoder: PasswordEncoder): ApiToModel<UserRegisterDto, UserEntity>, ModelToApi<UserEntity, UserResponseDto> {

    override fun toModel(dto: UserRegisterDto): UserEntity {
        return UserEntity(name = fullNameConverter(dto.firstName, dto.lastName),
            username = dto.username, email = dto.email, password = getPasswordEncoded(dto.password))
    }

    fun getPasswordEncoded(password: String): String {
        return passwordEncoder.encode(password)
    }

    fun fullNameConverter(firstName: String, lastName: String): String {
        val capitalFirstName = firstName.trim().replaceFirstChar { it.uppercase()}
        val capitalLastName = lastName.trim().replaceFirstChar { it.uppercase()}
        return "$capitalFirstName $capitalLastName"
    }

    override fun toApi(model: UserEntity): UserResponseDto {
        return UserResponseDto(fullName = model.name, username = model.username, email = model.email)
    }
}