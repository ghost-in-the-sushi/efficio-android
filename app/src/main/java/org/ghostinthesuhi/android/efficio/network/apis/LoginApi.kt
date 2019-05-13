package org.ghostinthesuhi.android.efficio.network.apis

import kotlinx.coroutines.Deferred
import org.ghostinthesuhi.android.efficio.network.Network.Companion.X_AUTH_TOKEN
import org.ghostinthesuhi.android.efficio.network.models.Auth
import org.ghostinthesuhi.android.efficio.network.models.Token
import org.ghostinthesuhi.android.efficio.network.models.User
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApi {

    @POST("login")
    fun loginAsync(@Body auth: Auth): Deferred<Token>

    @POST("user")
    fun createUserAsync(@Body user: User): Deferred<Token>

    @POST("logout")
    fun logout(@Header(X_AUTH_TOKEN) authToken: String): Deferred<Unit>
}