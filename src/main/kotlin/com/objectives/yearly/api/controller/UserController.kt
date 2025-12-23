package com.objectives.yearly.api.controller

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
@RequestMapping("/users")
class UserController(private val userService: UserService) {

//    @Operation(
//        summary = "Change user password",
//        description = "Change user password"
//    )
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "200", description = "Password change Successful"),
//            ApiResponse(responseCode = "400", description = "Bad Request"),
//            ApiResponse(responseCode = "500", description = "Internal Server Error")
//        ]
//    )it s
    @PostMapping("/password")
    fun changePassword(@Valid @RequestBody loginDto: UserLoginDto): ResponseEntity<Nothing> {
        userService.changePassword(loginDto)
        return ResponseEntity.ok().build()
    }

//    @Operation(
//        summary = "Change user password",
//        description = "Change user password"
//    )
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "200", description = "Password change Successful"),
//            ApiResponse(responseCode = "400", description = "Bad Request"),
//            ApiResponse(responseCode = "500", description = "Internal Server Error")
//        ]
//    )
    @PostMapping("/details")
    fun updateDetails(@Valid @RequestBody userDto: UserDto): ResponseEntity<UserResponseDto> {
        return ResponseEntity.ok(userService.userDetails(userDto))
    }

    @GetMapping("/details")
    fun getDetails(): ResponseEntity<UserResponseDto> {

        return ResponseEntity.ok(userService.getDetails())
    }

}