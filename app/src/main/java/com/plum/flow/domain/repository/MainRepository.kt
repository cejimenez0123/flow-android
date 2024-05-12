package com.plum.flow.domain.repository

import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token

interface MainRepository {

    suspend fun login(logInRequest: LogInRequest): Token?
}