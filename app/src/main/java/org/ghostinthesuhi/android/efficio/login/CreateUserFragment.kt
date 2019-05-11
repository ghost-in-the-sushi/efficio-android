package org.ghostinthesuhi.android.efficio.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_user.*
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.login.models.CreateUserViewModel
import org.ghostinthesuhi.android.efficio.network.PASSWORD
import org.koin.android.viewmodel.ext.android.viewModel

class CreateUserFragment : Fragment() {
    private val viewModel: CreateUserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        run {
            // Set fake data. TODO: remove
            username.setText("test")
            email.setText("test@test.com")
            password.setText(PASSWORD)
        }

        createUser.setOnClickListener {
            viewModel.createUser(
                email = email.text.toString(),
                username = username.text.toString(),
                password = password.text.toString()
            )
        }
    }
}