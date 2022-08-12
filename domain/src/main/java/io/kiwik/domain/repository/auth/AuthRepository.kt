package io.kiwik.domain.repository.auth

import io.kiwik.data.repository.AuthDataRepository
import io.kiwik.domain.util.BaseResponse
import io.kiwik.domain.util.toResponse

class AuthRepository : IAuthRepository {

    private val authDataRepository: AuthDataRepository by lazy {
        AuthDataRepository()
    }

    override suspend fun login(user: String, password: String): BaseResponse<Boolean> {
        return authDataRepository.login(user, password).toResponse()
    }

    override suspend fun signOut(): BaseResponse<Boolean> {
        return authDataRepository.signOut().toResponse()
    }

    override suspend fun isLogged(): BaseResponse<Boolean> {
        return BaseResponse.success(authDataRepository.isLogged())
    }

}