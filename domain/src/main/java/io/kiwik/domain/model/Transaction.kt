package io.kiwik.domain.model

import org.joda.time.DateTime

data class Transaction(
    val id: String,
    val name: String,
    val transactionAmount: Double,
    val date: DateTime
)