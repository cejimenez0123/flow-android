package com.plum.flow.di

import com.plum.flow.data.api.ApiService
import com.plum.flow.data.api.ForkApiService
import com.plum.flow.data.repository.MainRepositoryImpl
import com.plum.flow.domain.repository.MainRepository
import com.plum.flow.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService = ApiService.apiServiceInstance
    @Provides
    @Singleton
    fun provideforkApiService(): ForkApiService = ForkApiService.apiServiceInstance
    @Provides
    @Singleton
    fun provideMainRepo(mainApiService: ApiService):MainRepository=MainRepositoryImpl(mainApiService)
    @Provides
    @Singleton
    fun provideLoginUserCase(mainRepository: MainRepository):LoginUseCase=
        LoginUseCase(Dispatchers.IO,mainRepository)
}