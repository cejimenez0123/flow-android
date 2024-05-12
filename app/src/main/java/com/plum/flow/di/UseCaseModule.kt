package com.plum.flow.di

import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.repository.ForkRepository
import com.plum.flow.domain.repository.MainRepository
import com.plum.flow.usecase.ChildrenForkUseCase
import com.plum.flow.usecase.FocusForkUseCase
import com.plum.flow.usecase.ListFork
import com.plum.flow.usecase.LoginUseCase
import com.plum.flow.usecase.UseCase
import dagger.Binds
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

}

//    @Binds
//    @Singleton
//    fun provideLoginUseCase(mainRepository: MainRepository): LoginUseCase = LoginUseCase(Dispatchers.IO,mainRepository)

//    @Provides
//    @Singleton
//    fun provideFocusForkUseCase(forkRepository: ForkRepository):FocusForkUseCase=FocusForkUseCase(Dispatchers.IO,forkRepository)
//            //FocusForkUseCase = FocusForkUseCase(Dispatchers.IO, forkRepo = forkRepository)

//    @Provides
//    @Singleton
//    fun provideForkChildrenUseCase(forkRepository: ForkRepository):ChildrenForkUseCase=ChildrenForkUseCase(Dispatchers.IO,forkRepository)
//= FocusForkUseCase(Dispatchers.IO, forkRepo = forkRepository)