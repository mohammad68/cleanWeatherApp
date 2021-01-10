package com.example.domain.error

enum class ErrorType {
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    METHOD_NOT_ALLOWED,
    CONFLICT,
    INTERNAL_SERVER_ERROR,
    TIMEOUT,
    NO_CONNECTION,
    NETWORK_ERROR,
    UNKNOWN_ERROR
}