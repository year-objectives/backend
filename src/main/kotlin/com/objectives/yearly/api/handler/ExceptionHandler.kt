package com.objectives.yearly.api.handler

import com.objectives.yearly.api.dto.responses.GenericErrorDto
import com.objectives.yearly.domain.ResourceNotFoundException
import com.objectives.yearly.domain.UnauthorizedUserException
import com.objectives.yearly.domain.UserUnauthorizedException
import com.objectives.yearly.domain.UserAlreadyExistsException
import com.objectives.yearly.domain.UserUniqueFieldTakenException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): GenericErrorDto {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
                e ->
            errorMessage[e.field] = e.defaultMessage
        }
        return GenericErrorDto(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(UserUnauthorizedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleUserNotFound(
        exception: UserUnauthorizedException,
        request: HttpServletRequest
    ): GenericErrorDto {
        return GenericErrorDto(
            status = HttpStatus.UNAUTHORIZED.value(),
            error = HttpStatus.UNAUTHORIZED.name,
            message = exception.message.toString(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(UserAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleRegisterUserAlreadyExists(
        exception: UserAlreadyExistsException,
        request: HttpServletRequest
    ): GenericErrorDto {
        return GenericErrorDto(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = "User with username or email already exists",
            path = request.servletPath
        )
    }

    @ExceptionHandler(UserUniqueFieldTakenException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleRegisterUserAlreadyExists(
        exception: UserUniqueFieldTakenException,
        request: HttpServletRequest
    ): GenericErrorDto {
        return GenericErrorDto(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = exception.message.toString(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleGenericApiResourceNotFound(
        exception: ResourceNotFoundException,
        request: HttpServletRequest
    ): GenericErrorDto {
        return GenericErrorDto(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message.toString(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        exception: Exception,
        request: HttpServletRequest
    ): GenericErrorDto {
        return GenericErrorDto(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        exception: RuntimeException,
        request: HttpServletRequest
    ): GenericErrorDto {
        return GenericErrorDto(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path = request.servletPath
        )
    }

}