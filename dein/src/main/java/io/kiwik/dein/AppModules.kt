package io.kiwik.dein

import io.kiwik.data.sharedPreferences.AppSharedPreferencesManager
import io.kiwik.domain.interactors.GetProductsUseCase
import io.kiwik.domain.interactors.GetTransactionsUseCase
import io.kiwik.domain.interactors.LoginUseCase
import io.kiwik.domain.interactors.SignOutUseCase
import org.koin.dsl.module

val loginUseCase = module {
    single { LoginUseCase() }
}

val signOutUseCas = module {
    single { SignOutUseCase() }
}

val getProductsUseCase = module {
    single { GetProductsUseCase() }
}

val getTransactionsUseCase = module {
    single { GetTransactionsUseCase() }
}

val appSharedPreferences = module {
    single { AppSharedPreferencesManager(get()) }
}