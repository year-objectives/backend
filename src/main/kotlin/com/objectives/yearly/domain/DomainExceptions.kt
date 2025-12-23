package com.objectives.yearly.domain

class UserUnauthorizedException(override val message: String?) : RuntimeException(message)

class UserNotFoundException(override val message: String?) : RuntimeException(message)

class UserAlreadyExistsException(override val message: String?) : IllegalArgumentException(message)

class UserUniqueFieldTakenException(val filedName: String, override val message: String?) : IllegalArgumentException(message)

