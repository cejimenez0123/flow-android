package com.plum.flow.data.api

import com.google.gson.GsonBuilder
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/login")
    fun login(@Body logInRequest: LogInRequest): Response<String>
    companion object {
        private const val BASE_URL = "https://flow-node-api.onrender.com"
        val apiServiceInstance: ApiService by lazy {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)).build().create(
                ApiService::class.java)
        }
    }
    }
