package com.plum.flow.data.repository

import com.plum.flow.data.api.ForkApiService
import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.repository.ForkRepository

class ForkRepositoryImpl constructor(private val forkApi:ForkApiService):ForkRepository {
    override suspend fun getFocusFork(): Fork? {
        return forkApi.getFocusFork().body()
    }

    override suspend fun getForkChildren(id: String): List<Fork>? {
        return forkApi.getForkChildren(id).body()
    }


}