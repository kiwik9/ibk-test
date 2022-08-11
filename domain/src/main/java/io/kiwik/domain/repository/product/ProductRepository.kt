package io.kiwik.domain.repository.product

import io.kiwik.data.repository.ProductDataRepository
import io.kiwik.domain.mapper.ProductMapper
import io.kiwik.domain.mapper.TransactionMapper
import io.kiwik.domain.model.Product
import io.kiwik.domain.model.Transaction
import io.kiwik.domain.util.BaseResponse
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.domain.util.toResponse

class ProductRepository : IProductRepository {

    private val productDataRepository: ProductDataRepository by lazy {
        ProductDataRepository()
    }

    override suspend fun getProducts(): BaseResponse<List<Product>> {
        val result = productDataRepository.fetchProducts().toResponse()
        return when (result.responseStatus) {
            ResponseStatus.SUCCESS -> BaseResponse.success(ProductMapper.transformList(result.result!!.products))
            else -> BaseResponse.error(result.messageResponse)
        }
    }

    override suspend fun getTransactions(): BaseResponse<List<Transaction>> {
        val result = productDataRepository.fetchTransactions().toResponse()
        return when (result.responseStatus) {
            ResponseStatus.SUCCESS -> BaseResponse.success(TransactionMapper.transformList(result.result!!.transactions))
            else -> BaseResponse.error(result.messageResponse)
        }
    }

}