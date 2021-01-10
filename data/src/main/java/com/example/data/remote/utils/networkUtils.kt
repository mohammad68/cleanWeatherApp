package com.example.data.remote.utils

import com.example.domain.error.ErrorType
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeCallApi(apiCall: suspend () -> T): ApiResult<T>  =
    try {
      ApiResult.Success(apiCall.invoke())
    }catch (throwable: Throwable){
     when(throwable){
            is IOException ->  ApiResult.Error(ErrorType.NETWORK_ERROR)
            is HttpException -> when(throwable.code()){
                400 -> ApiResult.Error(ErrorType.BAD_REQUEST,throwable.message())
                401 -> ApiResult.Error(ErrorType.UNAUTHORIZED,throwable.message())
                403 -> ApiResult.Error(ErrorType.FORBIDDEN,throwable.message())
                404 -> ApiResult.Error(ErrorType.NOT_FOUND,throwable.message())
                500 -> ApiResult.Error(ErrorType.INTERNAL_SERVER_ERROR,throwable.message())
                else-> ApiResult.Error(ErrorType.UNKNOWN_ERROR,throwable.message())
            }
            else -> ApiResult.Error(ErrorType.UNKNOWN_ERROR,throwable.message)
        }
    }

