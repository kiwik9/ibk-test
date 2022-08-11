package io.kiwik.domain.util

data class BaseResponse<T>(
    val messageResponse: String,
    val responseStatus: ResponseStatus,
    val result: T? = null
) {
    companion object {
        fun <T> success(result: T): BaseResponse<T> {
            return BaseResponse("OK", ResponseStatus.SUCCESS, result)
        }

        fun <T> error(message: String): BaseResponse<T> {
            return BaseResponse(message, ResponseStatus.ERROR)
        }
    }
}