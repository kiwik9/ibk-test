package io.kiwik.domain.mapper

import io.kiwik.data.model.ProductModel
import io.kiwik.domain.model.Product

class ProductMapper {

    companion object {

        fun transform(obj: ProductModel): Product {
            return Product(obj.id, obj.name, obj.accountNumber, obj.accountMount)
        }

        fun transformList(list: List<ProductModel>): List<Product> {
            return list.map { transform(it) }
        }

    }
}