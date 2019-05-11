package org.ghostinthesuhi.android.efficio.koin

import org.ghostinthesuhi.android.efficio.login.LoginManager
import org.ghostinthesuhi.android.efficio.login.LoginManagerImpl
import org.ghostinthesuhi.android.efficio.network.Network
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single { Network(androidContext()) }
}

val loginModule = module {
    single<LoginManager> { LoginManagerImpl() }
}
