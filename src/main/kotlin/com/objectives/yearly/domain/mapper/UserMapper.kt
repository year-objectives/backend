package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.forms.UserRegisterForm
import com.objectives.yearly.api.dto.views.UserView
import com.objectives.yearly.domain.mapper.utils.ApiToModel
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(private val passwordEncoder: PasswordEncoder): ApiToModel<UserRegisterForm, UserEntity>, ModelToApi<UserEntity, UserView> {

    override fun toModel(api: UserRegisterForm): UserEntity {
        return UserEntity(name = fullNameConverter(api.firstName, api.lastName),
            username = api.username, email = api.email, password = passwordEncoder.encode(api.password))
    }

    override fun toView(model: UserEntity): UserView {
        return UserView(name = model.name, username = model.username, email = model.email)
    }

    private fun fullNameConverter(firstName: String, lastName: String): String {
        val capitalFirstName = firstName.trim().replaceFirstChar { it.uppercase()}
        val capitalLastName = lastName.trim().replaceFirstChar { it.uppercase()}
        return "$capitalFirstName $capitalLastName"
    }
}