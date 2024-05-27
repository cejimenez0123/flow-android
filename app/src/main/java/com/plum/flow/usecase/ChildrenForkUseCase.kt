package com.plum.flow.usecase

import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.repository.ForkRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


class ChildrenForkUseCase @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher, // Remove the private keyword here
    private val forkRepo: ForkRepository
) : UseCase<String, List<Fork>?>(coroutineDispatcher) {
    override suspend fun execute(parameters: String): List<Fork>? {
        return forkRepo.getForkChildren(parameters)
    }
}