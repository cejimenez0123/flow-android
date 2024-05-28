package com.plum.flow.usecase

import com.plum.flow.data.api.ApiService
import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.ForkList
import com.plum.flow.domain.model.TokenResponse
import com.plum.flow.domain.repository.ForkRepository
import com.plum.flow.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CheckTokenUseCase  @Inject constructor(
        private val coroutineDispatcher: CoroutineDispatcher, // Remove the private keyword here
        private val repo:MainRepository
    ) : UseCase<Any?, TokenResponse?>(coroutineDispatcher) {
        override suspend fun execute(parameters: Any?):TokenResponse? {
            return repo.checkToken()
        }
    }