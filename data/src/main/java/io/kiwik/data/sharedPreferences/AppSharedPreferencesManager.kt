package io.kiwik.data.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class AppSharedPreferencesManager(private val context: Context) {

    companion object {
        const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
        const val KEY_SESSION = "KEY_SESSION"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
    }

    fun saveSession(boolean: Boolean) {
        sharedPreferences.edit()
            .putBoolean(KEY_SESSION, boolean)
            .apply()
    }

    fun getSession(): Boolean {
        return sharedPreferences.getBoolean(KEY_SESSION, false)
    }

}