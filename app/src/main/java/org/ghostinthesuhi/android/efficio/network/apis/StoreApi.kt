package org.ghostinthesuhi.android.efficio.network.apis

import kotlinx.coroutines.Deferred
import org.ghostinthesuhi.android.efficio.network.ExpectedError
import org.ghostinthesuhi.android.efficio.network.Network.Companion.X_AUTH_TOKEN
import org.ghostinthesuhi.android.efficio.network.models.StoreLight
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import java.net.HttpURLConnection.HTTP_FORBIDDEN
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

interface StoreApi {
    @POST("store")
    @ExpectedError(HTTP_UNAUTHORIZED, "User not logged in")
    fun createStoreAsync(@Header(X_AUTH_TOKEN) authToken: String, @Body name: StoreNameBody): Deferred<CreateStoreResponse>

    @PUT("store/{storeId}")
    @ExpectedError(HTTP_UNAUTHORIZED, "User not logged in")
    @ExpectedError(HTTP_FORBIDDEN, "Resource does not belong to user")
    fun editStoreAsync(
        @Header(X_AUTH_TOKEN) authToken: String,
        @Path("storeId") storeId: String,
        @Body name: StoreNameBody
    ): Deferred<Unit>

    @DELETE("store")
    @ExpectedError(HTTP_UNAUTHORIZED, "User not logged in")
    @ExpectedError(HTTP_FORBIDDEN, "Resource does not belong to user")
    fun deleteStoreAsync(@Header(X_AUTH_TOKEN) authToken: String): Deferred<Unit>

    @GET("store")
    @ExpectedError(HTTP_UNAUTHORIZED, "User not logged in")
    fun listStoresAsync(@Header(X_AUTH_TOKEN) authToken: String): Deferred<ListStoreResponse>
}

data class CreateStoreResponse(val store_id: String)

data class ListStoreResponse(val stores: List<StoreLight>)

data class StoreNameBody(val name: String)
