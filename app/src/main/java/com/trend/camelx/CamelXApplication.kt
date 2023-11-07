package com.trend.camelx

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Ahmed Rabee for AREEB task on 11/5/2023
 */
@HiltAndroidApp
class CamelXApplication : Application()  {

    @Inject
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            FirebaseApp.initializeApp(this)
        }
    }

}