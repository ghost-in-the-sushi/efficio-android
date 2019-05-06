package org.ghostinthesuhi.android.efficio.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.network.Network
import org.ghostinthesuhi.android.efficio.network.apis.LoginApi
import org.ghostinthesuhi.android.efficio.network.models.Auth
import org.ghostinthesuhi.android.efficio.network.models.Token


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        signIn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                login()
            }
        }
    }

    suspend fun login(): Token {
        return Network[LoginApi::class].login(Auth("test", "test")).await()
    }
}