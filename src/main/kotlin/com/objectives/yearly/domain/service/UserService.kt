package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.forms.UserLoginForm
import com.objectives.yearly.api.dto.forms.UserRegisterForm
import com.objectives.yearly.api.dto.forms.toLogin
import com.objectives.yearly.api.dto.views.UserView
import com.objectives.yearly.domain.mapper.UserMapper
import com.objectives.yearly.infrastructure.database.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(val repository: UserRepository, val mapper: UserMapper,
    val jwtService: JwtService) {

    @Transactional
    fun registerUser(user: UserRegisterForm): String {
        repository.save(mapper.toModel(user))
        return jwtService.generateToken(user.toLogin())
    }

    fun getAll(): List<UserView> {
        return mapper.toView(repository.findAll())
    }

    fun loginUser(userForm: UserLoginForm): String {
        val user = repository.findByUserName(userForm.userName)
        if (user.password != userForm.password) {
            throw RuntimeException("Invalid password")
        }
        return jwtService.generateToken(UserLoginForm(user.password, user.userName))
    }
}