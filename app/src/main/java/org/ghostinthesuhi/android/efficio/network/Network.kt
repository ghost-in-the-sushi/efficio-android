package org.ghostinthesuhi.android.efficio.network

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.ghostinthesuhi.android.efficio.tools.getStringByResourceName
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.reflect.KClass

private const val BASE_URL = "base_url"

class Network(val context: Context) {
    private val apis = mutableMapOf<KClass<out Any>, Any>()

    private val baseUrl: String by lazy {
        context.getStringByResourceName(BASE_URL) ?: "http://127.0.0.1"
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    operator fun <T : Any> get(kClass: KClass<T>): T {
        @Suppress("UNCHECKED_CAST")
        return apis.getOrPut(kClass) {
            retrofit.create(kClass.java)
        } as T
    }
}