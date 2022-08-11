package io.kiwik.ibkapp.ui.home.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import io.kiwik.ibkapp.databinding.FragmentHomeBinding
import io.kiwik.ibkapp.ui.BaseFragment

class ProductsFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel : ProductsViewModel
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

    private fun setViewModel(){
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}