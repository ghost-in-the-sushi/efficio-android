package org.ghostinthesuhi.android.efficio.login.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.network.Result
import org.ghostinthesuhi.android.efficio.tools.Event

class LoginViewModel(
    private val loginManager: LoginManager
) : ViewModel() {
    val events = MutableLiveData<Event<Login>>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val message =
                when (val result = loginManager.loginAsync(username, password)) {
                    is Result.Success -> "Success"
                    is Result.Error -> {
                        "Error: ${result.throwable.localizedMessage}"
                    }
                }

            events.value = Event(Login.Toast(message))
        }
    }

    sealed class Login {
        data class Toast(val message: String) : Login()
    }
}