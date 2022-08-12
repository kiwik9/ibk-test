package io.kiwik.ibkapp.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Message
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.ibkapp.databinding.ActivityLoginBinding
import io.kiwik.ibkapp.ui.home.HomeActivity
import io.kiwik.ibkapp.utils.isNotNull
import io.kiwik.ibkapp.utils.isNull
import io.kiwik.ibkapp.workers.SessionWorker
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
    }

    private fun setObservers() {

        binding.editIdentifier.doOnTextChanged { text, _, _, _ ->
            viewModel.setUser(text.toString())
        }
        binding.editPassword.doOnTextChanged { text, _, _, _ ->
            viewModel.setPassword(text.toString())
        }

        binding.btnLogin.setOnClickListener {
            this.login()
        }

        lifecycleScope.launch {
            viewModel.formIsValid.collect {
                binding.btnLogin.isEnabled = it
            }
        }

    }

    private fun login() {
        lifecycleScope.launch {
            viewModel.login().collect {
                if (it.result == true) {
                    onLoginSuccess()
                } else {
                    onLoginError(it.message)
                }
            }
        }
    }


    private fun onLoginSuccess(){
        binding.txtError.isVisible = false
        initWorker()
        finish()
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
    }

    private fun onLoginError(message: String) {
        binding.txtError.isVisible = true
        binding.txtError.text = message
    }

    private fun initWorker() {
        val worker = OneTimeWorkRequest.Builder(SessionWorker::class.java)
            .setInitialDelay(2, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(this).enqueue(worker)
    }
}