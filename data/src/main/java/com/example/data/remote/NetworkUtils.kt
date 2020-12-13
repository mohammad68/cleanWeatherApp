package com.example.data.remote

import java.io.IOException

suspend fun <T> safeCallApi(apiCall: suspend () -> T): ApiResult<T> {
    return try {
       ApiResult.Success(apiCall.invoke())
    }catch (throwable: Throwable){
        when(throwable){
            is IOException -> Result.DataError(Error(NETWORK_ERROR,throwable.message))
            is HttpE -> Result.DataError(Error(SERVER_ERROR,throwable.message))
            else -> Result.DataError(Error(UNKNOWN_REMOTE_ERROR,throwable.message))
        }
    }
}
