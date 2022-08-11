package io.kiwik.data.model

import org.joda.time.DateTime

data class TransactionModel(
    val id: String,
    val name: String,
    val transactionAmount: Double,
    val date: DateTime
)