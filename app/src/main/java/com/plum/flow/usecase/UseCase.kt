package com.plum.flow.usecase

import com.plum.flow.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, R>() {

    suspend operator fun invoke(parameters: P,coroutineDispatcher:CoroutineDispatcher): Resource<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Resource.Success(it)
                }
            }
        } catch (e: Exception) {

            Resource.Error(e.toString())
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}