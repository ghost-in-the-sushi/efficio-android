package org.ghostinthesuhi.android.efficio.network.apis

import kotlinx.coroutines.Deferred
import org.ghostinthesuhi.android.efficio.network.ExpectedError
import org.ghostinthesuhi.android.efficio.network.Network.Companion.X_AUTH_TOKEN
import org.ghostinthesuhi.android.efficio.network.models.Auth
import org.ghostinthesuhi.android.efficio.network.models.Token
import org.ghostinthesuhi.android.efficio.network.models.User
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_NOT_ACCEPTABLE
import java.net.HttpURLConnection.HTTP_PRECON_FAILED
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

interface LoginApi {

    @POST("login")
    @ExpectedError(HTTP_PRECON_FAILED, "Missing fields")
    @ExpectedError(HTTP_BAD_REQUEST, "Invalid user of password")
    fun loginAsync(@Body auth: Auth): Deferred<Token>

    @POST("user")
    @ExpectedError(HTTP_PRECON_FAILED, "Missing fields or validation error")
    @ExpectedError(HTTP_NOT_ACCEPTABLE, "Username taken")
    fun createUserAsync(@Body user: User): Deferred<Token>

    @POST("logout")
    @ExpectedError(HTTP_UNAUTHORIZED, "User not logged in")
    fun logout(@Header(X_AUTH_TOKEN) authToken: String): Deferred<Unit>
}