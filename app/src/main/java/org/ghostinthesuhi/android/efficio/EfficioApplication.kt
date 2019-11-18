package org.ghostinthesuhi.android.efficio

import android.app.Application
import org.ghostinthesuhi.android.efficio.koin.loginModule
import org.ghostinthesuhi.android.efficio.koin.networkModule
import org.ghostinthesuhi.android.efficio.koin.storeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class EfficioApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@EfficioApplication)
            modules(listOf(networkModule, loginModule, storeModule))
        }
    }
}