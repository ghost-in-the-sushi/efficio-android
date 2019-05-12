package org.ghostinthesuhi.android.efficio.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_store.*
import org.ghostinthesuhi.android.efficio.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [StoreFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [StoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class StoreFragment : Fragment() {

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
    }
}
