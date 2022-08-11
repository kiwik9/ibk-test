package io.kiwik.data.api

import io.kiwik.data.util.ApiError
import io.kiwik.data.util.ResponseStatus
import retrofit2.Response

data class BaseApiResponse<T>(
    val status: ResponseStatus,
    val messageResponse: String,
    val response: T? = null
) {
    companion object {
        fun <T> success(response: T, message: String = "OK"): BaseApiResponse<T> {
            return BaseApiResponse(ResponseStatus.SUCCESS, message, response)
        }

        fun <A, B> error(response: Response<A>): BaseApiResponse<B> {
            return BaseApiResponse(ResponseStatus.FAILED, ApiError.getErrorApiError(response))
        }

        fun <B> errorWithMessage(message: String): BaseApiResponse<B> {
            return BaseApiResponse(ResponseStatus.FAILED, message)
        }

        fun <A> exception(exception: Exception): BaseApiResponse<A> {
            return BaseApiResponse(ResponseStatus.FAILED, exception.toString())
        }
    }
}

