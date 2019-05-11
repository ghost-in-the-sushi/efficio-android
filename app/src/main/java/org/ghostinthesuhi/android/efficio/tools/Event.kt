package org.ghostinthesuhi.android.efficio.tools

import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Useful type of [androidx.lifecycle.LiveData] for event bus, where you want events to be fired only once.
 */
class Event<T>(private val data: T) {
    private val fresh = AtomicBoolean(true)

    val value: T?
        get() = when {
            fresh.compareAndSet(true, false) -> data
            else -> null
        }
}

inline fun <T> eventObserver(crossinline onChanged: (value: T) -> Unit): Observer<Event<T>> {
    return Observer { t -> t.value?.let(onChanged) }
}