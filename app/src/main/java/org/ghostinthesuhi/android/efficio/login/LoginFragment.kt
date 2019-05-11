package org.ghostinthesuhi.android.efficio.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.network.Network
import org.ghostinthesuhi.android.efficio.network.PASSWORD
import org.ghostinthesuhi.android.efficio.network.apis.LoginApi
import org.ghostinthesuhi.android.efficio.network.models.Auth
import org.ghostinthesuhi.android.efficio.network.models.Token
import org.koin.android.ext.android.inject
import retrofit2.Response

class LoginFragment : Fragment() {
    private val network:Network by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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

        signUp.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(LoginFragmentDirections.actionLoginFragmentToCreateUserFragment())
        }
    }

    suspend fun login(): Response<Token> {
        return network[LoginApi::class].login(Auth("test", PASSWORD)).await()
    }
}
