package org.ghostinthesuhi.android.efficio.login.data

import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.network.models.Token

interface LoginManager {
    val isLoggedIn: Boolean

    val authToken: String?

    suspend fun loginAsync(username: String, password: String): Result<Token>

    suspend fun createUserAsync(email: String, username: String, password: String): Result<Token>
}