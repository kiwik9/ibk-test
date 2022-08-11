package io.kiwik.domain.interactors

import io.kiwik.domain.UseCase
import io.kiwik.domain.repository.auth.AuthRepository
import io.kiwik.domain.util.BaseResponse

class LoginUseCase(
    private val authRepository: AuthRepository
) : UseCase() {

    suspend fun execute(user: String, password: String): BaseResponse<Boolean> {
        return authRepository.login(user, password)
    }

}