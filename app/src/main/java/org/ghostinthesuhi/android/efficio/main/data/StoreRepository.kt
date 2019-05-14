package org.ghostinthesuhi.android.efficio.main.data

import androidx.lifecycle.LiveData
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.network.models.StoreLight

interface StoreRepository {
    fun getStoreList(): LiveData<List<StoreLight>>
    fun getCurrentStore(): LiveData<StoreLight>
    suspend fun getStoreAsync(storeId: String): StoreLight?

    suspend fun createStore(name: String): Result<Unit>
    suspend fun updateStore(storeId: String, name: String): Result<Unit>
}