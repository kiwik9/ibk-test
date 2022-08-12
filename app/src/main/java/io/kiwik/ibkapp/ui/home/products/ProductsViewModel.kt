package io.kiwik.ibkapp.ui.home.products

import androidx.lifecycle.ViewModel
import io.kiwik.domain.interactors.GetProductsUseCase
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.ibkapp.utils.ResponseView
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductsViewModel : ViewModel(), KoinComponent {

    private val getProductsUseCase by inject<GetProductsUseCase>()

    fun getProducts() = flow {
        val result = getProductsUseCase.execute()
        when (result.responseStatus) {
            ResponseStatus.SUCCESS -> {
                emit(ResponseView.success(result.result))
            }
            else -> {
                emit(ResponseView.error(result.messageResponse))
            }
        }
    }
}