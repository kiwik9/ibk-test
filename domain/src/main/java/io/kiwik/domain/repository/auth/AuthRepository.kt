package io.kiwik.domain.repository.auth

import io.kiwik.domain.model.Product
import io.kiwik.domain.util.BaseResponse

class AuthRepository : IAuthRepository{

    override suspend fun login(): BaseResponse<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun signOut(): BaseResponse<Boolean> {
        TODO("Not yet implemented")
    }

}