package org.ghostinthesuhi.android.efficio.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_store.*
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.main.models.StoreFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class StoreFragment : Fragment() {
    private val viewModel: StoreFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingButton.setOnClickListener {
            loadingButton.isLoading = !loadingButton.isLoading
        }

        enableButton.setOnClickListener {
            loadingButton.isEnabled = !loadingButton.isEnabled
        }

        viewModel.storeList.observe(this, Observer {
        })
        viewModel.store.observe(this, Observer {
            setTitle(it.name)
        })
    }

    private fun setTitle(title: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }
}
