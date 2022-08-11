package io.kiwik.data.api

data class BaseApiResponse<T>(
    val status: Int,
    val messageResponse: String,
    val body: T?
)