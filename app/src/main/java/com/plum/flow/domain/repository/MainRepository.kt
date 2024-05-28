package com.plum.flow.domain.repository

import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.model.TokenResponse

interface MainRepository {

    suspend fun login(logInRequest: LogInRequest): Token?
    suspend fun checkToken(): TokenResponse?
}