package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.definition.UserController
import com.objectives.yearly.api.dto.requests.UserDto
import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.responses.UserResponseDto
import com.objectives.yearly.domain.service.UserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl(private val userService: UserService): UserController {

    override fun changePassword(@Valid @RequestBody loginDto: UserLoginDto): ResponseEntity<Nothing> {
        userService.changePassword(loginDto)
        return ResponseEntity.ok().build()
    }

    override fun updateDetails(@Valid @RequestBody userDto: UserDto): ResponseEntity<UserResponseDto> {
        return ResponseEntity.ok(userService.userDetails(userDto))
    }

    override fun getDetails(): ResponseEntity<UserResponseDto> {

        return ResponseEntity.ok(userService.getDetails())
    }

}