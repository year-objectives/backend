package com.objectives.management.api.dto.utils

object OpenApiUtils {
    class ResponseDto {
        companion object {
            const val OBJECTIVE = "ObjectiveResponseDto"
            const val TAG = "TagResponseDto"
            const val USER = "UserResponseDto"
            const val GENERIC_ERROR = "GenericErrorResponseDto"
            const val AUTHENTICATED = "AuthenticatedResponseDto"
            const val ACCOMPLISHMENT = "AccomplishmentResponseDto"
        }
    }

    class RequestDto {
        companion object {
            const val USER_LOGIN = "UserLoginRequestDto"
            const val USER_REFRESH = "UserRefreshRequestDto"
            const val USER_REGISTER = "UserRegisterRequestDto"
            const val ACCOMPLISHMENT = "AccomplishmentRequestDto"
            const val OBJECTIVE = "ObjectiveRequestDto"
            const val TAG = "TagRequestDto"
            const val USER = "UserRequestDto"
            const val USER_PASSWORD = "UserRequestDto"
        }
    }

    class RequestDtoExamples {
        companion object {
            const val USER_LOGIN = """
                {
                  "username": "marimi",
                  "password": "12345"
                }
            """
            const val USER_REFRESH = """
                {
                  "refresh_token_id": "45568403-2291-46dc-9c3f-63dcc7f2b1ea"
                }
            """
            const val USER_REGISTER = """
                {
                  "username": "marimi",
                  "first_name": "maria",
                  "last_name": "miguel",
                  "email": "email@domain.com",
                  "password": "12345"
                }
            """
            const val ACCOMPLISHMENT = """
                {
                  "objective_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                  "done": true,
                  "done_at": 1766762378,
                  "description": "I went earlier today"
                }
            """
            const val OBJECTIVE = """
                {
                  "name": "Going to gym",
                  "target_amount": 3,
                  "type": "WEEKLY",
                  "reversible": false,
                  "description": "I want to be strong",
                  "tags": ["3fa85f64-5717-4562-b3fc-2c963f66afa6", "3fa85f64-5717-4562-b3fc-2c963f66afa6"]
                }
            """
            const val TAG = """
                {
                  "name": "exercise"
                }
            """
            const val USER = """
                {
                  "first_name": "jane",
                  "last_name": "doe",
                  "email": "email@domai.com",
                  "username": "mamima"
                }
            """
            const val USER_PASSWORD = """
                {
                  "password": "12345"
                }
            """
        }
    }

    class ResponseDtoExamples {
        companion object {
            const val OBJECTIVE = """
                {
                  "name": "Going to gym",
                  "target_amount": 3,
                  "type": "WEEKLY",
                  "reversible": false,
                  "description": "I want to be strong",
                  "tags": ["3fa85f64-5717-4562-b3fc-2c963f66afa6", "3fa85f64-5717-4562-b3fc-2c963f66afa6"],
                  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6"
                }
            """
            const val ACCOMPLISHMENT = """
                {
                  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                  "objective_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                  "done": true,
                  "done_at": 1766762378,
                  "description": "I went earlier today"
                }
            """
            const val AUTHENTICATED = """
                {
                  "auth_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0NDRmN2EyMC0wYmI3LTQ0ODEtODdlYi04NGY1ZWI1OGY1ZjAiLCJpYXQiOjE3NjY3NjczNDcsImV4cCI6MTc2Njc2OTE0N30._mJDPVXr5TieyC-SUzU7CiAb2HIE1JOTpalODICGT7ox-rkYwZOV_ne0DW_xpNXxx9m9jMYBkWMy8-r9zrwp2w",
                  "refresh_token_id": "7474c12a-36dc-461b-8e1a-ae95dfd96b21"
                }
            """
            const val UNAUTHORIZED_ERROR = """
                {
                  "timestamp": 1766767366249,
                  "status": 401,
                  "error": "UNAUTHORIZED",
                  "message": "User unauthorized.",
                  "path": "/auth/refresh-token"
                }
            """
            const val INTERNAL_SERVER_ERROR = """
                {
                  "timestamp": 1766767366249,
                  "status": 500,
                  "error": "INTERNAL_SERVER_ERROR",
                  "message": "Server crashed",
                  "path": "/auth/refresh-token"
                }
            """
            const val BAD_REQUEST_ERROR = """
                {
                  "timestamp": 1766767366249,
                  "status": 400,
                  "error": "BAD_REQUEST",
                  "message": "Field name can not be null or blank",
                  "path": "/objectives"
                }
            """
            const val NOT_FOUND_ERROR = """
                {
                  "timestamp": 1766767366249,
                  "status": 404,
                  "error": "NOT_FOUND",
                  "message": "Resource not found",
                  "path": "/objectives"
                }
            """
            const val TAG = """
                {
                  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                  "name": "personal finances"
                }
            """
            const val USER = """
                {
                  "full_name": "Jane Doe",
                  "email": "email@domai.com",
                  "username": "mamima"
                }
            """
        }
    }

}

