package io.kiwik.ibkapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.kiwik.domain.interactors.GetCurrentSessionUseCase
import io.kiwik.ibkapp.ui.login.LoginActivity
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseActivity : AppCompatActivity(), KoinComponent {

    private val currentSessionUseCase by inject<GetCurrentSessionUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        validateSession()
    }

    private fun validateSession() {
        lifecycleScope.launch {
            val result = currentSessionUseCase.execute().result
            if (result == false) {
                toLoginActivity()
            }
        }
    }

    private fun toLoginActivity() {
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }

}