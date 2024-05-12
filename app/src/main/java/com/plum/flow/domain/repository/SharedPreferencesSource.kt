package com.plum.flow.domain.repository

import com.plum.flow.domain.model.Token

interface SharedPreferencesSource {
    fun setToken(token: Token)
    fun getToken(): Token?
    fun clearToken()
}