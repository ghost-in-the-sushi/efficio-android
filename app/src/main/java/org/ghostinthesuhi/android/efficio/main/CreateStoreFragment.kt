package org.ghostinthesuhi.android.efficio.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_create_store.*
import org.ghostinthesuhi.android.efficio.R
import org.ghostinthesuhi.android.efficio.main.models.CreateStoreViewModel
import org.ghostinthesuhi.android.efficio.main.models.CreateStoreViewModel.Actions.SaveSuccessful
import org.ghostinthesuhi.android.efficio.tools.eventObserver
import org.koin.android.viewmodel.ext.android.viewModel

class CreateStoreFragment : Fragment() {
    private val viewModel: CreateStoreViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.events.observe(this, eventObserver {
            when (it) {
                SaveSuccessful -> {
                    findNavController().navigateUp()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.save_action, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save -> {
                viewModel.createStore(store_name.text.toString().trim())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}