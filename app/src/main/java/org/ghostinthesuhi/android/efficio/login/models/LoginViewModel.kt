package org.ghostinthesuhi.android.efficio.login.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.tools.Event

class LoginViewModel(
    private val loginManager: LoginManager
) : ViewModel() {
    val events = MutableLiveData<Event<Actions>>()
    val isSigningUp = MutableLiveData<Boolean>(false)

    private var signInJob:Job? = null

    fun login(username: String, password: String) {
        signInJob = viewModelScope.launch {
            isSigningUp.value = true
            when (val result = loginManager.loginAsync(username, password)) {
                is Result.Success -> events.value = Event(Actions.LoginSuccess)
                is Result.Error -> {
                    events.value = Event(Actions.ShowToast("Error: ${result.throwable.localizedMessage}"))
                }
            }
            isSigningUp.value = false
        }
    }

    fun cancelLogin(){
        signInJob?.cancel()
    }

    sealed class Actions {
        data class ShowToast(val message: String) : Actions()
        object LoginSuccess : Actions()
    }
}