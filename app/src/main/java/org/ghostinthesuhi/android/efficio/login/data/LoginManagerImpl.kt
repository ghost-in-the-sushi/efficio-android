package org.ghostinthesuhi.android.efficio.login.data

import android.content.Context
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.network.apis.LoginApi
import org.ghostinthesuhi.android.efficio.network.models.Auth
import org.ghostinthesuhi.android.efficio.network.models.Token
import org.ghostinthesuhi.android.efficio.network.models.User
import org.ghostinthesuhi.android.efficio.network.safeAwait

private const val LOGIN_DATA = "login_data"
private const val KEY_AUTH_TOKEN = "key_auth_token"

class LoginManagerImpl(
    context: Context,
    private val loginApi: LoginApi
) : LoginManager {
    /**
     * TODO: delete this abomination. Auth Token should not be stored in a shared pref.
     * Adding that here for fast prototyping.
     */
    private val tokenSharedPreferences = context.getSharedPreferences(LOGIN_DATA, Context.MODE_PRIVATE)
    private val logoutListener = mutableListOf<() -> Unit>()

    override val authToken: String?
        get() {
            return tokenSharedPreferences.getString(KEY_AUTH_TOKEN, null)
        }

    override val isLoggedIn: Boolean
        get() = authToken != null

    override suspend fun loginAsync(username: String, password: String): Result<Token> {
        val result = loginApi.loginAsync(Auth(username, password)).safeAwait()
        if (result is Result.Success) {
            tokenSharedPreferences.edit().putString(KEY_AUTH_TOKEN, result.data.session_token).apply()
        }
        return result
    }

    override suspend fun createUserAsync(email: String, username: String, password: String): Result<Token> {
        val result = loginApi.createUserAsync(User(email, username, password)).safeAwait()
        if (result is Result.Success) {
            tokenSharedPreferences.edit().putString(KEY_AUTH_TOKEN, result.data.session_token).apply()
        }
        return result
    }

    override suspend fun logOut() {
        authToken?.let { authToken ->
            loginApi.logoutAsync(authToken).safeAwait()
            cleanUp()
        }
    }

    override suspend fun deleteUser() {
        authToken?.let { authToken ->
            loginApi.deleteUserAsync(authToken).safeAwait()
            cleanUp()
        }
    }

    override fun registerLogoutListener(listener: () -> Unit) {
        logoutListener.add(listener)
    }

    private fun cleanUp() {
        tokenSharedPreferences.edit().remove(KEY_AUTH_TOKEN).apply()
        logoutListener.forEach { it() }
    }
}