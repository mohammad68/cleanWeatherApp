package com.example.domain.util
import com.example.domain.error.ErrorType

sealed class DataState<out R> {
    data class Success<out T>(val data: T): DataState<T>()
    data class Error(val errorState: ErrorType,val errorMessage: String?,): DataState<Nothing>()
    object Loading: DataState<Nothing>()
}