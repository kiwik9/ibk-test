package io.kiwik.ibkapp.ui.login

import androidx.lifecycle.ViewModel
import io.kiwik.domain.interactors.LoginUseCase
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.ibkapp.utils.ResponseView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val user = MutableStateFlow("")
    private val password = MutableStateFlow("")
    private val loginUseCase by inject<LoginUseCase>()

    fun setUser(user: String) {
        this.user.value = user
    }

    fun setPassword(pass: String) {
        this.password.value = pass
    }

    private fun getUser(): String {
        return this.user.value
    }

    private fun getPassword(): String {
        return this.password.value
    }

    val formIsValid = combine(
        user,
        password
    ) { user, password ->
        val userIsValid = user.length > 5
        val passwordIsValid = password.length > 5
        userIsValid and passwordIsValid
    }

    fun login() = flow {
        val result = loginUseCase.execute(getUser(), getPassword())
        when (result.responseStatus) {
            ResponseStatus.SUCCESS -> {
                emit(ResponseView.success(result.result))
            }
            else -> {
                emit(ResponseView.error(result.messageResponse))
            }
        }
    }

}