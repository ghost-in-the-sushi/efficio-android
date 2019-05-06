package org.ghostinthesuhi.android.efficio.network.apis

import kotlinx.coroutines.Deferred
import org.ghostinthesuhi.android.efficio.network.models.Auth
import org.ghostinthesuhi.android.efficio.network.models.Token
import org.ghostinthesuhi.android.efficio.network.models.User
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("login")
    fun login(@Body auth: Auth): Deferred<Token>

    @POST("user")
    fun createUser(@Body user: User):Deferred<Token>
}