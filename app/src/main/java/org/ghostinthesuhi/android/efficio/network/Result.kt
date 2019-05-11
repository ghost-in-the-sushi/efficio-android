package org.ghostinthesuhi.android.efficio.network

import kotlinx.coroutines.Deferred

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val throwable: Throwable) : Result<Nothing>()
}

suspend fun <T : Any> safeAwait(deferred: Deferred<T>): Result<T> {
    return try {
        Result.Success(deferred.await())
    } catch (throwable: Throwable) {
        Result.Error(throwable)
    }
}