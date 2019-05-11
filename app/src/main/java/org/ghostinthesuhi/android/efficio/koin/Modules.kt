package org.ghostinthesuhi.android.efficio.koin

import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.login.data.LoginManagerImpl
import org.ghostinthesuhi.android.efficio.login.models.CreateUserViewModel
import org.ghostinthesuhi.android.efficio.login.models.LoginViewModel
import org.ghostinthesuhi.android.efficio.network.Network
import org.ghostinthesuhi.android.efficio.network.apis.LoginApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { Network(androidContext()) }
}

val loginModule = module {
    factory { get<Network>()[LoginApi::class] }
    single<LoginManager> {
        LoginManagerImpl(
            androidContext(),
            get()
        )
    }
    viewModel { LoginViewModel(get()) }
    viewModel { CreateUserViewModel(get()) }
}
