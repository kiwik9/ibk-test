package io.kiwik.data.api.response

import io.kiwik.data.model.ProductModel

data class FetchProductsResponse(
    val products: List<ProductModel>
)