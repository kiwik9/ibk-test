package io.kiwik.domain.repository.product

import io.kiwik.domain.model.Product
import io.kiwik.domain.model.Transaction
import io.kiwik.domain.util.BaseResponse

class ProductRepository : IProductRepository {

    override suspend fun getProducts(): BaseResponse<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTransactions(): BaseResponse<List<Transaction>> {
        TODO("Not yet implemented")
    }

}