package org.ghostinthesuhi.android.efficio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ghostinthesuhi.android.efficio.login.LoginActivity
import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.main.MainActivity
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context) = Intent(context, SplashActivity::class.java)
    }

    private val loginManager: LoginManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(if (loginManager.isLoggedIn) MainActivity.intent(this) else LoginActivity.intent(this))
        finish()
    }
}