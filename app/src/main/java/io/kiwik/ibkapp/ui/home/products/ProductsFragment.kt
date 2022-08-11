package io.kiwik.ibkapp.ui.home.products

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.ibkapp.databinding.FragmentHomeBinding
import io.kiwik.ibkapp.ui.BaseFragment
import io.kiwik.ibkapp.ui.adapter.ProductListAdapter
import io.kiwik.ibkapp.ui.product_detail.ProductDetailActivity
import io.kiwik.ibkapp.utils.Constants
import io.kiwik.ibkapp.utils.showToast
import kotlinx.coroutines.launch

class ProductsFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: ProductListAdapter
    private lateinit var viewModel: ProductsViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setViewModel()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {
        setAdapter()
        getProducts()
        setActions()
    }

    private fun setActions() {
        binding.swipeRefresh.setOnRefreshListener {
            getProducts()
        }
    }

    private fun getProducts() {
        lifecycleScope.launch {
            viewModel.getProducts().collect {
                binding.swipeRefresh.isRefreshing = false
                when (it.responseStatus) {
                    ResponseStatus.SUCCESS -> {
                        adapter.submitList(it.result!!)
                    }
                    else -> {
                        requireContext().showToast(it.messageResponse)
                    }
                }
            }
        }
    }

    private fun setAdapter() {
        adapter = ProductListAdapter()
        binding.rvProducts.adapter = adapter
        adapter.setOnItemClickListener {
            val intent = Intent(requireContext(), ProductDetailActivity::class.java)
            intent.putExtra(Constants.KEY_PRODUCT_NAME, it.name)
            intent.putExtra(Constants.KEY_PRODUCT_AMOUNT, it.accountMount)
            intent.putExtra(Constants.KEY_PRODUCT_ACCOUNT, it.accountNumber)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}