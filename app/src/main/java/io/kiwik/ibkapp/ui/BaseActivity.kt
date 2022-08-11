package io.kiwik.ibkapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import io.kiwik.data.sharedPreferences.AppSharedPreferencesManager
import io.kiwik.ibkapp.ui.login.LoginActivity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseActivity : AppCompatActivity(), KoinComponent {
    private val sharedPreferences by inject<AppSharedPreferencesManager>()

    override fun onResume() {
        super.onResume()
        validateSession()
    }

    private fun validateSession() {
        if (!sharedPreferences.getSession()) {
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}