package org.ghostinthesuhi.android.efficio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ghostinthesuhi.android.efficio.login.LoginActivity
import org.ghostinthesuhi.android.efficio.login.LoginManager
import org.ghostinthesuhi.android.efficio.main.MainActivity
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {
    private val loginManager: LoginManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(if (loginManager.isLoggedIn) MainActivity.intent(this) else LoginActivity.intent(this))
        finish()
    }
}