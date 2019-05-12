package org.ghostinthesuhi.android.efficio.tools

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

fun Context.getStringByResourceName(name: String): String? {
    val identifier = resources.getIdentifier(name, "string", packageName)
    return if (identifier == 0) {
        null
    } else {
        getString(identifier)
    }
}

@ColorInt
fun Context.getThemeColor(@AttrRes attributeName: Int): Int {
    val typedValue = TypedValue()
    val typedArray = obtainStyledAttributes(typedValue.data, intArrayOf(attributeName))
    try {
        return typedArray.getColor(0, Color.BLACK)
    } finally {
        typedArray.recycle()
    }
}