package org.ghostinthesuhi.android.efficio.tools

class SizeConstrainedMap<Key, Value>(private val maximumSize: Int) : LinkedHashMap<Key, Value>() {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Key, Value>?): Boolean {
        return size > maximumSize
    }
}