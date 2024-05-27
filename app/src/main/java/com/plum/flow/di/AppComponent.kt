package com.plum.flow.di

import android.content.Context
import com.plum.flow.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [SharedModule::class,UseCaseModule::class,ApiModule::class,RepoModule::class] )
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        fun context(@BindsInstance context: Context): Builder
        fun build(): AppComponent
    }
}
