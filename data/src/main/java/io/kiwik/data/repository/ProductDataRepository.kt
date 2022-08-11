package io.kiwik.data.repository

import io.kiwik.data.api.ApiClient
import io.kiwik.data.api.BaseApiResponse
import io.kiwik.data.api.response.FetchProductsResponse
import io.kiwik.data.api.response.FetchTransactionsResponse
import io.kiwik.data.model.ProductModel
import io.kiwik.data.model.TransactionModel
import org.joda.time.DateTime
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductDataRepository : KoinComponent {

    private val networkApiService by inject<ApiClient>()

    suspend fun fetchProducts(): BaseApiResponse<FetchProductsResponse> {
        /*       try {
                   val service = networkApiService.createService(ApiService::class.java)
                   val result = service.fetchProducts(FetchProductsRequest())
                   if (result.isSuccessful) {
                       val body = result.body() ?: return BaseApiResponse.error(result)
                       return BaseApiResponse.success(body)
                   } else {
                       return BaseApiResponse.error(result)
                   }

               } catch (e: Exception){
                   return BaseApiResponse.exception(e)
               }
       */
        val response = FetchProductsResponse(
            listOf(
                ProductModel("1", "Cuenta Ahorro", "", 124.0),
                ProductModel("2", "Cuenta Sueldo", "", 20.40),
                ProductModel("3", "Cuanta Ahorro 2", "", 2040.0)
            )
        )
        return BaseApiResponse.success(response)
    }

    suspend fun fetchTransactions(): BaseApiResponse<FetchTransactionsResponse> {
        /*  try {
              val service = networkApiService.createService(ApiService::class.java)
              val result = service.fetchTransactions(FetchTransactionsRequest())
              if (result.isSuccessful) {
                  val body = result.body() ?: return BaseApiResponse.error(result)
                  return BaseApiResponse.success(body)
              } else {
                  return BaseApiResponse.error(result)
              }

          } catch (e: Exception){
              return BaseApiResponse.exception(e)
          }*/
        val now = DateTime.now()
        val response = FetchTransactionsResponse(
            listOf(
                TransactionModel("1", "Plin 1", -5.50, now.plusDays(-1)),
                TransactionModel("2", "Transferencia 2", 250.50, now.plusDays(-2)),
                TransactionModel("3", "Transferencia 4", -1200.50, now.plusDays(1)),
            )
        )
        return BaseApiResponse.success(response)
    }

}