package io.kiwik.domain.repository.product

import io.kiwik.domain.model.Product
import io.kiwik.domain.model.Transaction
import io.kiwik.domain.util.BaseResponse

interface IProductRepository {
    suspend fun getProducts() : BaseResponse<List<Product>>
    suspend fun getTransactions() : BaseResponse<List<Transaction>>
}