package com.plum.flow.data.repository

import com.plum.flow.data.api.ApiService
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.model.TokenResponse
import com.plum.flow.domain.repository.MainRepository
import com.plum.flow.domain.repository.SharedPreferencesSource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
        private val apiService: ApiService,
        private val sharedPref: SharedPreferencesSource):MainRepository{
    override suspend fun login(logInRequest: LogInRequest): Token? {
        var token = apiService.login(logInRequest).body()
        return token
    }

    override suspend fun checkToken(): TokenResponse? {
       return sharedPref.getToken()?.token?.run{
            apiService.checkToken(this).body()
        }

    }
}