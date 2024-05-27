package com.plum.flow.di

import android.content.Context

import com.plum.flow.data.repository.SharedPreferencesSourceImpl

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
    fun bindSharedPreferencesSource(@ApplicationContext appContext: Context): SharedPreferencesSource{
        return SharedPreferencesSourceImpl(appContext)
    }

}