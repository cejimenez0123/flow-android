package com.plum.flow.usecase

import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.ForkList
import com.plum.flow.domain.repository.ForkRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ProtectedForksUseCase @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val forkRepo: ForkRepository
) : UseCase<String, List<Fork>?>(coroutineDispatcher) {
    override suspend fun execute(parameters: String): ForkList? {
        return forkRepo.getProtectedForks(parameters)
    }
}