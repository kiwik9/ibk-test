package io.kiwik.ibkapp.ui.product_detail

import androidx.lifecycle.ViewModel
import io.kiwik.domain.interactors.GetTransactionsUseCase
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.ibkapp.utils.ResponseView
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductDetailViewModel : ViewModel(), KoinComponent {

    private val getTransactionsUseCase by inject<GetTransactionsUseCase>()


    fun getTransactions() = flow {
        val result = getTransactionsUseCase.execute()
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