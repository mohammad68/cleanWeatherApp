package com.example.data.remote.utils

import com.example.domain.error.ErrorType

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T): ApiResult<T>()
    data class Error(
        val errorState: ErrorType,
        val errorMessage: String? = null
    ): ApiResult<Nothing>()
    override fun toString(): String {
        return when(this){
            is Success<*> -> "Success[$data]"
            is Error -> "Error[Code: $errorState | Message: $errorMessage]"
        }
    }
}