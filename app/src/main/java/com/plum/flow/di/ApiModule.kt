package com.plum.flow.di

import com.plum.flow.data.api.ApiService
import com.plum.flow.data.api.ForkApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object ApiModule  {
    @Provides
    @Singleton
    fun bindApiService():ApiService=ApiService.apiServiceInstance
    @Provides
    @Singleton
    fun bindForkApiService():ForkApiService=ForkApiService.apiServiceInstance

}