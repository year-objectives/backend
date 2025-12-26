package com.objectives.yearly.domain

import org.springframework.security.core.AuthenticationException

class UserUnauthorizedException(override val message: String?) : RuntimeException(message)

class UserNotFoundException(override val message: String?) : RuntimeException(message)

class UserAlreadyExistsException(override val message: String?) : RuntimeException(message)

class UserUniqueFieldTakenException(override val message: String?) : IllegalArgumentException(message)

class ResourceNotFoundException(override val message: String?) : RuntimeException(message)

class UnauthorizedUserException(override val message: String?) : AuthenticationException(message)