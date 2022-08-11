package io.kiwik.ibkapp.ui.home.products

import androidx.lifecycle.ViewModel
import io.kiwik.domain.interactors.GetProductsUseCase
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductsViewModel : ViewModel(), KoinComponent {

    private val getProductsUseCase by inject<GetProductsUseCase>()

    fun getProducts() = flow {
        val result = getProductsUseCase.execute()
        emit(result)
    }
}