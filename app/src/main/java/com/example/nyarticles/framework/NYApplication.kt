package com.example.nyarticles.framework

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.example.nyarticles.BuildConfig
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class NYApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }
    }
}