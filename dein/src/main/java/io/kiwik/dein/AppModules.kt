package io.kiwik.dein

import io.kiwik.data.api.ApiClient
import org.koin.dsl.module

val networkModule = module {
    single { ApiClient() }
}
