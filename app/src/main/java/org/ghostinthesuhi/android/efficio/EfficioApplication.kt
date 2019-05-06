package org.ghostinthesuhi.android.efficio

import android.app.Application

class EfficioApplication : Application() {
    companion object {
        private lateinit var _instance: EfficioApplication
        val instance get() = _instance
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }
}