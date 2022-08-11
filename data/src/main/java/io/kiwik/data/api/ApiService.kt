package io.kiwik.data.api

import io.kiwik.data.api.request.FetchProductsRequest
import io.kiwik.data.api.request.FetchTransactionsRequest
import io.kiwik.data.api.request.LoginRequest
import io.kiwik.data.api.response.FetchProductsResponse
import io.kiwik.data.api.response.FetchTransactionsResponse
import io.kiwik.data.api.response.LoginResponse
import io.kiwik.data.util.ApiConstants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(ApiConstants.PATH_LOGIN)
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST(ApiConstants.PATH_FETCH_PRODUCTS)
    suspend fun fetchProducts(@Body request: FetchProductsRequest): Response<FetchProductsResponse>

    @POST(ApiConstants.PATH_FETCH_TRANSACTIONS)
    suspend fun fetchTransactions(@Body request: FetchTransactionsRequest): Response<FetchTransactionsResponse>

}