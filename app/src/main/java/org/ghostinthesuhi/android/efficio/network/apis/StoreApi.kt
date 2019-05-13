package org.ghostinthesuhi.android.efficio.network.apis

import kotlinx.coroutines.Deferred
import org.ghostinthesuhi.android.efficio.network.Network.Companion.X_AUTH_TOKEN
import org.ghostinthesuhi.android.efficio.network.models.StoreLight
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface StoreApi {
    @POST("store")
    fun createStoreAsync(@Header(X_AUTH_TOKEN) authToken: String, @Body name: String): Deferred<CreateStoreResult>

    @PUT("store")
    fun editStoreAsync(@Header(X_AUTH_TOKEN) authToken: String, @Body name: String): Deferred<Unit>

    @DELETE("store")
    fun deleteStoreAsync(@Header(X_AUTH_TOKEN) authToken: String): Deferred<Unit>

    @GET("store")
    fun listStoresAsync(@Header(X_AUTH_TOKEN) authToken: String): Deferred<ListStoreResult>
}

data class CreateStoreResult(val store_id: String)

data class ListStoreResult(val stores: List<StoreLight>)
