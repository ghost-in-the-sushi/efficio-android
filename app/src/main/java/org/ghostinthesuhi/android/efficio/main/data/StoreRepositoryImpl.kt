package org.ghostinthesuhi.android.efficio.main.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.network.apis.StoreApi
import org.ghostinthesuhi.android.efficio.network.apis.StoreNameBody
import org.ghostinthesuhi.android.efficio.network.models.StoreLight
import org.ghostinthesuhi.android.efficio.network.safeAwait

class StoreRepositoryImpl(private val authToken: String, private val storeApi: StoreApi) : StoreRepository {
    private val currentlySelectedStore = MutableLiveData<StoreLight>()
    private val stores: MutableLiveData<List<StoreLight>>by lazy {
        MutableLiveData<List<StoreLight>>().also {
            refreshStoreList()
        }
    }
    private val refreshJob: Job? = null

    private fun refreshStoreList() {
        if (refreshJob?.isActive == true) return
        CoroutineScope(Dispatchers.IO).launch {
            val result = storeApi.listStoresAsync(authToken).safeAwait()
            if (result is Result.Success) {
                stores.postValue(result.data.stores)
                if (currentlySelectedStore.value == null) {
                    result.data.stores.firstOrNull()?.let {
                        currentlySelectedStore.postValue(it)
                    }
                }
            }
        }
    }

    override fun getCurrentStore(): LiveData<StoreLight> {
        return currentlySelectedStore
    }

    override suspend fun getStoreAsync(storeId: String): StoreLight? {
        return withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            stores.value?.firstOrNull { it.store_id == storeId }
        }
    }

    override fun getStoreList(): LiveData<List<StoreLight>> = stores

    override suspend fun createStore(name: String): Result<Unit> {
        return when (val result = storeApi.createStoreAsync(authToken, StoreNameBody(name)).safeAwait()) {
            is Result.Success -> {
                val newStore = StoreLight(name, result.data.store_id)
                currentlySelectedStore.value = newStore
                stores.value = (stores.value?.toMutableList() ?: mutableListOf()).plus(newStore)

                Result.Success(Unit)
            }
            is Result.Error -> result
        }
    }

    override suspend fun updateStore(storeId: String, name: String): Result<Unit> {
        return when (val result = storeApi.editStoreAsync(authToken, storeId, StoreNameBody(name)).safeAwait()) {
            is Result.Success -> {
                val updatedStore = StoreLight(name, storeId)
                if (storeId == currentlySelectedStore.value?.store_id) {
                    currentlySelectedStore.postValue(updatedStore)
                }
                stores.value?.toMutableList()?.map {
                    if (storeId == it.store_id) updatedStore else it
                }?.let { stores.value = it }

                Result.Success(Unit)
            }
            is Result.Error -> result
        }
    }
}