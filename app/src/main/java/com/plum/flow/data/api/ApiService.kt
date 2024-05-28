package com.plum.flow.data.api

import com.google.gson.GsonBuilder
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.model.TokenResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    suspend fun login(@Body logInRequest: LogInRequest): Response<Token>
    @GET("auth/")
    suspend fun checkToken( @Header("Authorization") token:String):Response<TokenResponse>
    companion object {
        private const val BASE_URL = "https://flow-node-production.up.railway.app/"
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
