package org.ghostinthesuhi.android.efficio.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.network.Network
import org.ghostinthesuhi.android.efficio.network.PASSWORD
import org.ghostinthesuhi.android.efficio.network.apis.LoginApi
import org.ghostinthesuhi.android.efficio.network.models.User
import org.koin.android.ext.android.inject

class CreateUserFragment : Fragment() {
    private val network:Network by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createUser.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = network[LoginApi::class]
                    .createUser(User("test@test.com", "test", PASSWORD))
                    .await()

                result.body()?.let { token ->
                    Log.d("Create user", "AuthToken = ${token.session_token}")
                }
            }
        }
    }
}