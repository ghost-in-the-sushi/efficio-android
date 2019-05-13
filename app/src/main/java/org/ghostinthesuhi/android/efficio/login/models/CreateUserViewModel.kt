package org.ghostinthesuhi.android.efficio.login.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.tools.Event

class CreateUserViewModel(private val loginManager: LoginManager) : ViewModel() {
    val events = MutableLiveData<Event<Actions>>()
    private val _isSigningUp = MutableLiveData<Boolean>(false)
    val isSigningUp: LiveData<Boolean> get() = _isSigningUp

    fun createUser(email: String, username: String, password: String) {
        _isSigningUp.value = true
        viewModelScope.launch {
            when (val result = loginManager.createUserAsync(email = email, username = username, password = password)) {
                is Result.Success -> events.value = Event(Actions.CreateUserSuccess)
                is Result.Error -> events.value = Event(Actions.ShowToast(result.throwable.localizedMessage))
            }
            _isSigningUp.value = false
        }
    }

    sealed class Actions {
        data class ShowToast(val message: String) : Actions()
        object CreateUserSuccess : Actions()
    }
}