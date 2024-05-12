package com.plum.flow.di

import com.plum.flow.data.api.ApiService
import com.plum.flow.data.api.ForkApiService
import com.plum.flow.data.repository.ForkRepositoryImpl
import com.plum.flow.data.repository.MainRepositoryImpl
import com.plum.flow.domain.repository.ForkRepository
import com.plum.flow.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule  {
    @Binds
    @Singleton
    fun bindMainRepository(impl: MainRepositoryImpl): MainRepository

    @Binds
    @Singleton
    fun bindForkRepository(impl: ForkRepositoryImpl): ForkRepository


}