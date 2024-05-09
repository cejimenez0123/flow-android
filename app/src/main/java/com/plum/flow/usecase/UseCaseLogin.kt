package com.plum.flow.usecase

import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.repository.MainRepository
import com.plum.flow.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val mainRepository: MainRepository
): UseCase<LogInRequest, Token?>() {

    override suspend fun execute(logInRequest: LogInRequest): Token? {
       val token = mainRepository.login(logInRequest = logInRequest)
     return token
    }

}