package io.kiwik.ibkapp.ui.product_detail

import androidx.lifecycle.ViewModel
import io.kiwik.domain.interactors.GetProductsUseCase
import io.kiwik.domain.interactors.GetTransactionsUseCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductDetailViewModel : ViewModel(), KoinComponent {

    private val getTransactionsUseCase by inject<GetTransactionsUseCase>()


    fun getTransactions() = flow {
        val result = getTransactionsUseCase.execute()
        emit(result)
    }

}