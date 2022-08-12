package io.kiwik.dein

import io.kiwik.data.api.ApiClient
import io.kiwik.data.sharedPreferences.AppSharedPreferencesManager
import io.kiwik.domain.interactors.*
import io.kiwik.domain.repository.auth.AuthRepository
import io.kiwik.domain.repository.product.ProductRepository
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

val authRepository = module {
    single { AuthRepository() }
}

val productRepository = module {
    single { ProductRepository() }
}

val currentSessionUseCase = module {
    single { GetCurrentSessionUseCase(get()) }
}
