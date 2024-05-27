package com.plum.flow.data.repository

import com.plum.flow.data.api.ForkApiService
import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.ForkList
import com.plum.flow.domain.model.Style
import com.plum.flow.domain.repository.ForkRepository
import java.util.Date
import javax.inject.Inject

class ForkRepositoryImpl @Inject constructor(private val forkApi:ForkApiService):ForkRepository {
    override suspend fun getFocusFork(): Fork? {
       return forkApi.getFocusFork().body()


    }

    override suspend fun getForkChildren(id: String): ForkList? {
        var body = forkApi.getForkChildren(id).body()
        return body
    }


}