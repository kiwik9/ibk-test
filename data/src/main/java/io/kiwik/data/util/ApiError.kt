package io.kiwik.data.util

import retrofit2.Response

class ApiError {
    companion object {
        fun <T> getErrorApiError(result: Response<T>): String {
            return if (result.errorBody() != null) result.errorBody()
                .toString() else result.message()
        }
    }
}