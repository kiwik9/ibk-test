package io.kiwik.domain.repository.auth

import io.kiwik.domain.model.Product
import io.kiwik.domain.model.Transaction
import io.kiwik.domain.util.BaseResponse

interface IAuthRepository {
    suspend fun login() : BaseResponse<List<Product>>
    suspend fun signOut(): BaseResponse<Boolean>
}