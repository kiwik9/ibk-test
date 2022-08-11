package io.kiwik.ibkapp.ui

import android.app.Application
import io.kiwik.dein.*
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                listOf(
                    loginUseCase,
                    signOutUseCase,
                    getProductsUseCase,
                    getTransactionsUseCase,
                    networkApiService,
                    appSharedPreferences
                )
            )
        }
    }
}