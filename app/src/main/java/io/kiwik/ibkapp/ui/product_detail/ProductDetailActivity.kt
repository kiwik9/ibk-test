package io.kiwik.ibkapp.ui.product_detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.kiwik.domain.model.Transaction
import io.kiwik.ibkapp.databinding.ActivityProductDetailBinding
import io.kiwik.ibkapp.ui.adapter.TransactionListAdapter
import io.kiwik.ibkapp.utils.*
import kotlinx.coroutines.launch

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var adapter: TransactionListAdapter
    private val viewModel: ProductDetailViewModel by viewModels()
    private var name: String? = null
    private var amount: Double? = null
    private var account: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        getIntentData()
        setData()
        setAdapter()
        getTransactions()
        setActions()
    }

    private fun setData() {
        binding.txtTitleProduct.text = name
        binding.txtAmountProduct.text = "S/ $amount"
        binding.txtAccountNumber.text = account
    }

    private fun getIntentData() {
        name = intent.getStringExtra(Constants.KEY_PRODUCT_NAME)
        account = intent.getStringExtra(Constants.KEY_PRODUCT_ACCOUNT)
        amount = intent.getDoubleExtra(Constants.KEY_PRODUCT_AMOUNT, 0.0)
        validateData()
    }

    private fun validateData() {
        if (name.isNull() or account.isNull() or amount.isNull()) {
            showToast("No se trajo la data correctamente.")
            finish()
        }
    }

    private fun setActions() {
        binding.swipeRefresh.setOnRefreshListener {
            getTransactions()
        }

        binding.btnShareProduct.setOnClickListener {
            shareContent()
        }
    }

    private fun shareContent() {
        val contentText = SharedTextUtil.getSharedText(account!!)
        SharedTextUtil.shareContent(this, contentText)
    }

    private fun getTransactions() {
        lifecycleScope.launch {
            viewModel.getTransactions().collect {
                binding.swipeRefresh.isRefreshing = false
                if (it.result.isNotNull()) {
                    onSuccessGetTransactions(it.result!!)
                } else {
                    onErrorGetTransactions(it.message)
                }
            }
        }
    }

    private fun onSuccessGetTransactions(list: List<Transaction>) {
        adapter.submitList(list)
    }

    private fun onErrorGetTransactions(message: String) {
        showToast(message)
    }

    private fun setAdapter() {
        adapter = TransactionListAdapter(this)
        binding.rvTransactions.adapter = adapter
    }


}