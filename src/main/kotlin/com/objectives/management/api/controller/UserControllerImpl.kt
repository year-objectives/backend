package com.objectives.management.api.controller

import com.objectives.management.api.controller.definition.UserController
import com.objectives.management.api.dto.requests.UserDto
import com.objectives.management.api.dto.requests.UserPasswordDto
import com.objectives.management.api.dto.responses.UserResponseDto
import com.objectives.management.domain.service.UserService
import org.springframework.http.ResponseEntity
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