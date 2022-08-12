package io.kiwik.data.repository

import io.kiwik.data.api.BaseApiResponse
import io.kiwik.data.sharedPreferences.AppSharedPreferencesManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthDataRepository : KoinComponent {

    private val sharedPreferences by inject<AppSharedPreferencesManager>()

    suspend fun signOut(): BaseApiResponse<Boolean> {
        sharedPreferences.saveSession(false)
        return BaseApiResponse.success(sharedPreferences.getSession())
    }

    suspend fun login(user: String, password: String): BaseApiResponse<Boolean> {
        if (user == "123456" && password == "123456") {
            sharedPreferences.saveSession(true)
            return BaseApiResponse.success(sharedPreferences.getSession())
        }
        return BaseApiResponse.errorWithMessage("Usuario y/o contrasena incorrecta.")
    }

    suspend fun isLogged(): Boolean {
        return sharedPreferences.getSession()
    }

}