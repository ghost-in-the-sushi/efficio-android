package org.ghostinthesuhi.android.efficio.tools

import android.content.Context

fun Context.getStringByResourceName(name: String): String? {
    val identifier = resources.getIdentifier(name, "string", packageName)
    return if (identifier == 0) {
        null
    } else {
        getString(identifier)
    }
}