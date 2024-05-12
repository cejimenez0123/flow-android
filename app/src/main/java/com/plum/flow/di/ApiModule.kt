package com.plum.flow.di

import com.plum.flow.data.api.ApiService
import com.plum.flow.data.api.ForkApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideSharedModule():SharedModule=SharedModule
//    @Provides
//    @Singleton
//    fun provideUseCaseModule(sharedModule: SharedModule):UseCaseModule
//    =UseCaseModule(mainRepository = sharedModule.provideMainRepo(sharedModule.provideApiService()), forkRepository = sharedModule.provideForkRepo(sharedModule.provideForkApiService()))
//    @Provides
//    @Singleton
//    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferencesSource {
//        return SharedPreferencesSourceImpl(context)
//    }
//
//}

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