package org.ghostinthesuhi.android.efficio.koin

import org.ghostinthesuhi.android.efficio.login.data.LoginManager
import org.ghostinthesuhi.android.efficio.login.data.LoginManagerImpl
import org.ghostinthesuhi.android.efficio.login.models.CreateUserViewModel
import org.ghostinthesuhi.android.efficio.login.models.LoginViewModel
import org.ghostinthesuhi.android.efficio.main.data.StoreRepository
import org.ghostinthesuhi.android.efficio.main.data.StoreRepositoryImpl
import org.ghostinthesuhi.android.efficio.main.models.CreateStoreViewModel
import org.ghostinthesuhi.android.efficio.main.models.StoreFragmentViewModel
import org.ghostinthesuhi.android.efficio.network.Network
import org.ghostinthesuhi.android.efficio.network.apis.LoginApi
import org.ghostinthesuhi.android.efficio.network.apis.StoreApi
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

val storeModule = module {
    factory { get<Network>()[StoreApi::class] }
    single<StoreRepository> { StoreRepositoryImpl(get(), get()) }
    viewModel { StoreFragmentViewModel(get()) }
    viewModel { CreateStoreViewModel(get()) }
}
