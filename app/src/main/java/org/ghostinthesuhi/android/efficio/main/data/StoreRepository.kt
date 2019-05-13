package org.ghostinthesuhi.android.efficio.main.data

import androidx.lifecycle.LiveData
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.network.models.Store
import org.ghostinthesuhi.android.efficio.network.models.StoreLight

interface StoreRepository {
    fun getStoreList(): LiveData<List<StoreLight>>
    fun getCurrentStore(): LiveData<StoreLight>

    suspend fun createStore(name: String): Result<Unit>
}