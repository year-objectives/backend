package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.definition.UserController
import com.objectives.yearly.api.dto.requests.UserDto
import com.objectives.yearly.api.dto.requests.UserPasswordDto
import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.responses.UserResponseDto
import com.objectives.yearly.domain.service.UserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl(private val userService: UserService): UserController {

    override fun changePassword(userPasswordDto: UserPasswordDto): ResponseEntity<Nothing> {
        userService.changePassword(userPasswordDto)
        return ResponseEntity.ok().build()
    }

    override fun updateDetails(userDto: UserDto): ResponseEntity<UserResponseDto> {
        return ResponseEntity.ok(userService.userDetails(userDto))
    }

    override fun getDetails(): ResponseEntity<UserResponseDto> {

        return ResponseEntity.ok(userService.getDetails())
    }

}