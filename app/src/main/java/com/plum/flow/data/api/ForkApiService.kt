package com.plum.flow.data.api

import com.google.gson.GsonBuilder
import com.plum.flow.domain.model.Fork
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface ForkApiService {
    @GET("fork/")
    fun getAdminForks():Response<Fork>

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