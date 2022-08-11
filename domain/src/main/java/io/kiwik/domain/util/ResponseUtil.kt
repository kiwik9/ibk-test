package io.kiwik.domain.util

import io.kiwik.data.api.BaseApiResponse
import io.kiwik.data.util.ResponseStatus

fun <T> BaseApiResponse<T>.toResponse(): BaseResponse<T> {
    return when (this.status) {
        ResponseStatus.SUCCESS -> {
            BaseResponse.success(this.response!!)
        }
        else -> {
            BaseResponse.error(this.messageResponse)
        }
    }
}

fun <T, B> BaseApiResponse<T>.toResponseWithData(data: B): BaseResponse<B> {
    return when (this.status) {
        ResponseStatus.SUCCESS -> {
            BaseResponse.success(data)
        }
        else -> {
            BaseResponse.error(this.messageResponse)
        }
    }
}