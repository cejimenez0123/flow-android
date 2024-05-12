package com.plum.flow.usecase

import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.repository.ForkRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

typealias ListFork = List<Fork>
class ChildrenForkUseCase @Inject constructor(
    val coroutineDispatcher: CoroutineDispatcher, // Remove the private keyword here
    private val forkRepo: ForkRepository
) : UseCase<String, ListFork?>(coroutineDispatcher) {
    override suspend fun execute(id: String): List<Fork>? {
        return forkRepo.getForkChildren(id)
    }
}