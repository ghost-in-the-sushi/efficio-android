package org.ghostinthesuhi.android.efficio.tools

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

fun <T, R> LiveData<T>.map(transform: (T) -> R): LiveData<R> {
    return Transformations.map(this, Function(transform))
}