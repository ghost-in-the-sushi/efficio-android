package org.ghostinthesuhi.android.efficio.main.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.main.data.StoreRepository
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.tools.Event

class CreateStoreViewModel(val storeRepository: StoreRepository) : ViewModel() {
    private val _isCreatingStore = MutableLiveData<Boolean>(false)
    val isCreatingStore: LiveData<Boolean> get() = _isCreatingStore
    val events = MutableLiveData<Event<Actions>>()

    fun createStore(name: String) {
        if (_isCreatingStore.value == true) return

        _isCreatingStore.value = true
        viewModelScope.launch {
            val result = storeRepository.createStore(name)
            if (result is Result.Success) {
                events.postValue(Event(Actions.SaveSuccessful))
            }
            _isCreatingStore.value = false
        }
    }

    sealed class Actions {
        object SaveSuccessful : Actions()
    }
}