package org.ghostinthesuhi.android.efficio.tools

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService

fun View.hideKeyboard() {
    val inputMethodManager = context.getSystemService<InputMethodManager>()
    inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)
}