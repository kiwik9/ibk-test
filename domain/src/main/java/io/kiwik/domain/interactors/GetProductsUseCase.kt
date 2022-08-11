package io.kiwik.domain.interactors

import io.kiwik.domain.UseCase
import io.kiwik.domain.model.Product
import io.kiwik.domain.repository.product.ProductRepository
import io.kiwik.domain.util.BaseResponse

class GetProductsUseCase(
    private val productRepository: ProductRepository
) : UseCase() {

    suspend fun execute(): BaseResponse<List<Product>> {
        return productRepository.getProducts()
    }

}