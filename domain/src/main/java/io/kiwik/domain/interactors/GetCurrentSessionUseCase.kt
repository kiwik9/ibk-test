package io.kiwik.domain.interactors

import io.kiwik.domain.UseCase
import io.kiwik.domain.repository.auth.AuthRepository
import io.kiwik.domain.repository.product.ProductRepository
import io.kiwik.domain.util.BaseResponse

class GetCurrentSessionUseCase(
    private val authRepository: AuthRepository
) : UseCase() {

    suspend fun execute(): BaseResponse<Boolean> {
        return authRepository.isLogged()
    }
}