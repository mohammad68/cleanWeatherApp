package com.example.data.remote

sealed class ApiResult<out T> {
    data class Success<out T>(val value: T): ApiResult<T>()
    data class GenericError(
            val code: Int? = null,
            val errorMessage: String? = null
    ):ApiResult<Nothing>()
    object NetworkError: ApiResult<Nothing>()
    object Loading: ApiResult<Nothing>()

    override fun toString(): String {
        return when(this){
            is Success<*> -> "Success[$value]"
            is GenericError -> "Generic Error[Code: $code | Message: $errorMessage]"
            is NetworkError -> "Network Error"
            Loading -> "Loading"
        }
    }
}