package io.kiwik.dein

import io.kiwik.data.api.ApiClient
import io.kiwik.data.sharedPreferences.AppSharedPreferencesManager
import io.kiwik.domain.interactors.GetProductsUseCase
import io.kiwik.domain.interactors.GetTransactionsUseCase
import io.kiwik.domain.interactors.LoginUseCase
import io.kiwik.domain.interactors.SignOutUseCase
import org.koin.dsl.module

val loginUseCase = module {
    single { LoginUseCase(get()) }
}

val signOutUseCase = module {
    single { SignOutUseCase(get()) }
}

val getProductsUseCase = module {
    single { GetProductsUseCase(get()) }
}

val getTransactionsUseCase = module {
    single { GetTransactionsUseCase(get()) }
}

val networkApiService = module {
    single { ApiClient() }
}

val appSharedPreferences = module {
    single { AppSharedPreferencesManager(get()) }
}