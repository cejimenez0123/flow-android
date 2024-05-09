package com.plum.flow

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FlowApplication: Application() {

    override fun onCreate() {
        super.onCreate()

    }
}