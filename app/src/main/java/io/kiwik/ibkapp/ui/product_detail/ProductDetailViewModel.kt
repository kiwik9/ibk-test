package io.kiwik.ibkapp.ui.product_detail

import androidx.lifecycle.ViewModel
import io.kiwik.domain.interactors.GetTransactionsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject

class ProductDetailViewModel : ViewModel(), KoinComponent{

    private val getTransactionsUseCase by inject<GetTransactionsUseCase>()

}