package io.kiwik.ibkapp.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
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
            viewModel.loginResponse.collect {
                when (it.responseStatus) {
                    ResponseStatus.SUCCESS -> {
                        binding.txtError.isVisible = false
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            initWorker()
                        }
                        finish()
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                    }
                    else -> {
                        binding.txtError.isVisible = true
                        binding.txtError.text = it.messageResponse
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initWorker() {
        val worker = OneTimeWorkRequest.Builder(SessionWorker::class.java)
            .setInitialDelay(2, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(this).enqueue(worker)
    }
}