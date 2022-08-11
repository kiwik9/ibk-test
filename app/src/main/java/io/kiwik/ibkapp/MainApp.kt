package io.kiwik.ibkapp

import android.app.Application
import io.kiwik.dein.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApp)
            modules(
                listOf(
                    loginUseCase,
                    signOutUseCase,
                    getProductsUseCase,
                    getTransactionsUseCase,
                    networkApiService,
                    appSharedPreferences,
                    authRepository,
                    productRepository
                )
            )
        }
    }
}