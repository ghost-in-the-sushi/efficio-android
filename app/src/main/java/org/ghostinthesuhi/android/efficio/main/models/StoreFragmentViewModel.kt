package org.ghostinthesuhi.android.efficio.main.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.ghostinthesuhi.android.efficio.main.data.StoreRepository
import org.ghostinthesuhi.android.efficio.network.models.StoreLight

class StoreFragmentViewModel(private val storeRepository: StoreRepository) : ViewModel() {
    val storeList: LiveData<List<StoreLight>> get() = storeRepository.getStoreList()
    val store: LiveData<StoreLight> get() = storeRepository.getCurrentStore()
}