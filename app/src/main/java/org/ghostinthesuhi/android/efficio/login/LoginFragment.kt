package org.ghostinthesuhi.android.efficio.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.ghostinthesuhi.android.efficio.CoroutineFragment
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.login.models.LoginViewModel
import org.ghostinthesuhi.android.efficio.network.PASSWORD
import org.ghostinthesuhi.android.efficio.tools.eventObserver
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : CoroutineFragment() {
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        run {
            // Set fake data. TODO: remove
            username.setText("test")
            password.setText(PASSWORD)
        }

        signIn.setOnClickListener {
            viewModel.login(username.text.toString(), password.text.toString())
        }

        viewModel.events.observe(this, eventObserver {
            when (it) {
                is LoginViewModel.Login.Toast -> toast(it.message)
            }
        })

        signUp.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(LoginFragmentDirections.actionLoginFragmentToCreateUserFragment())
        }
    }

    private fun toast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}
