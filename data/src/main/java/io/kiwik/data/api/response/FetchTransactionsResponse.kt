package io.kiwik.data.api.response

import io.kiwik.data.model.TransactionModel

data class FetchTransactionsResponse(
    val transactions: List<TransactionModel>
)