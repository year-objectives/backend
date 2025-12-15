package com.objectives.yearly.domain

class UserNotFoundException(val username: String, override val message: String?) : RuntimeException(message)

class UserAlreadyExistsException(val username: String, override val message: String?) : IllegalArgumentException(message)
