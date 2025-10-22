package com.objectives.yearly.api.controller

import com.objectives.yearly.api.dto.forms.UserLoginForm
import com.objectives.yearly.api.dto.forms.UserRegisterForm
import com.objectives.yearly.domain.service.JwtService
import com.objectives.yearly.domain.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserController(val userService: UserService, val jwtService: JwtService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody @Valid user: UserRegisterForm): String {
        return userService.registerUser(user)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody @Valid user: UserLoginForm): String {
        return userService.loginUser(user)
    }

    @PostMapping("/logout")
    fun logoutUser(token: String) {
        jwtService.invalidateToken(token)
    }

}