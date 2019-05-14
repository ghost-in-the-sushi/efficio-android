package org.ghostinthesuhi.android.efficio.main.models

import androidx.lifecycle.ViewModel
import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.main.data.StoreRepository

class MainViewModel(
    private val loginManager: LoginManager,
    storeRepository: StoreRepository
) :
    ViewModel() {
    val currentStore = storeRepository.getCurrentStore()
}