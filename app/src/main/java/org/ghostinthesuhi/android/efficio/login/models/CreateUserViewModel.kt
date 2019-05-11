package org.ghostinthesuhi.android.efficio.login.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.login.data.LoginManager

class CreateUserViewModel(val loginManager: LoginManager) : ViewModel() {

    fun createUser(email: String, username: String, password: String) {
        viewModelScope.launch {
            loginManager.createUserAsync(email = email, username = username, password = password)
        }
    }
}