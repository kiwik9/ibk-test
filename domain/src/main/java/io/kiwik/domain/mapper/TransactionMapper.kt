package io.kiwik.domain.mapper

import io.kiwik.data.model.ProductModel
import io.kiwik.data.model.TransactionModel
import io.kiwik.domain.model.Product
import io.kiwik.domain.model.Transaction

class TransactionMapper {

    companion object {

        fun transform(obj: TransactionModel): Transaction {
            return Transaction(obj.id, obj.name,obj.transactionAmount, obj.date)
        }

        fun transformList(list: List<TransactionModel>): List<Transaction> {
            return list.map { transform(it) }
        }

    }
}