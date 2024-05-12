package com.plum.flow.usecase

import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.repository.ForkRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class FocusForkUseCase @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val forkRepo: ForkRepository
): UseCase<Unit, Fork?>(coroutineDispatcher){
    override suspend fun execute(parameters: Unit): Fork? {
        return forkRepo.getFocusFork()
    }

}