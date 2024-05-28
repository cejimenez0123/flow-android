package com.plum.flow.di

import com.plum.flow.domain.repository.ForkRepository
import com.plum.flow.domain.repository.MainRepository
import com.plum.flow.usecase.CheckTokenUseCase
import com.plum.flow.usecase.ChildrenForkUseCase
import com.plum.flow.usecase.FocusForkUseCase
import com.plum.flow.usecase.LoginUseCase
import com.plum.flow.usecase.ProtectedForksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule  {
    @Provides
    @Singleton
    fun provideLoginUseCase(mainRepository: MainRepository):LoginUseCase=LoginUseCase(Dispatchers.IO,mainRepository)

    @Provides
    @Singleton
    fun provideFocusForkUseCase(forkRepository: ForkRepository):FocusForkUseCase=FocusForkUseCase(Dispatchers.IO,forkRepository)

    @Provides
    @Singleton
    fun provideChildrenForkUseCase(forkRepository: ForkRepository):ChildrenForkUseCase=ChildrenForkUseCase(Dispatchers.IO,forkRepository)
    @Provides
    @Singleton
    fun provideProtectedForkUseCase(forkRepository: ForkRepository): ProtectedForksUseCase =ProtectedForksUseCase(Dispatchers.IO,forkRepository)
    @Provides
    @Singleton
    fun provideCheckToken(mainRepository: MainRepository):CheckTokenUseCase=CheckTokenUseCase(Dispatchers.IO,mainRepository)
}

