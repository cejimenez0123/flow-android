package com.plum.flow.di

import android.content.Context
import com.plum.flow.data.api.ApiService
import com.plum.flow.data.api.ForkApiService
import com.plum.flow.data.repository.ForkRepositoryImpl
import com.plum.flow.data.repository.MainRepositoryImpl
import com.plum.flow.data.repository.SharedPreferencesSourceImpl
import com.plum.flow.domain.repository.ForkRepository
import com.plum.flow.domain.repository.MainRepository
import com.plum.flow.domain.repository.SharedPreferencesSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedModule  {
    @Provides
    @Singleton
    fun bindSharedPreferencesSource(@ApplicationContext context: Context): SharedPreferencesSource=SharedPreferencesSourceImpl(context)

}