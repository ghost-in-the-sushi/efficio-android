package org.ghostinthesuhi.android.efficio

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

open class CoroutineFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = ViewModelProviders.of(this).get<CoroutineFragmentContextHolder>().viewModelScope.coroutineContext

    class CoroutineFragmentContextHolder : ViewModel()
}