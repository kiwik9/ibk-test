package io.kiwik.domain.interactors

import io.kiwik.domain.UseCase
import io.kiwik.domain.model.Transaction
import io.kiwik.domain.repository.product.ProductRepository
import io.kiwik.domain.util.BaseResponse

class GetTransactionsUseCase(
    private val productRepository: ProductRepository
) : UseCase() {

    suspend fun execute(): BaseResponse<List<Transaction>> {
        return productRepository.getTransactions()
    }

}