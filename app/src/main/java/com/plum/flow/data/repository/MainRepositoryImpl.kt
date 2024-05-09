package com.plum.flow.data.repository

import com.plum.flow.data.api.ApiService
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(val apiService: ApiService):MainRepository{
    override fun login(logInRequest: LogInRequest): Token? {
        var tolen = apiService.login(logInRequest).body()
        println("xttoken"+tolen)
        return Token("")
    }
}