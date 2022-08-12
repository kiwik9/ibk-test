package io.kiwik.ibkapp.utils

data class ResponseView<T>(
    val result: T? = null,
    val message: String
) {
    companion object {
        fun <T> success(result: T, message: String = "Ok"): ResponseView<T> {
            return ResponseView(result, message)
        }

        fun <T> error(message: String): ResponseView<T> {
            return ResponseView(message = message)
        }
    }
}