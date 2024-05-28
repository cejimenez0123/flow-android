package com.plum.flow.data.api

import com.google.gson.GsonBuilder
import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.ForkList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ForkApiService {
    @GET("fork/")
    suspend fun getFocusFork():Response<Fork>

    @GET("fork/children/{id}")
    suspend fun getForkChildren(@Path("id")id:String):Response<ForkList>

    @GET("fork/protected/children/{id}")
    suspend fun getProtectedForks(@Path("id")id:String, @Header("Authorization") token:String):Response<ForkList>

    companion object {
        private const val BASE_URL = "https://flow-node-production.up.railway.app/"
        val apiServiceInstance: ForkApiService by lazy {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)).build().create(
                    ForkApiService::class.java)
        }
    }
}