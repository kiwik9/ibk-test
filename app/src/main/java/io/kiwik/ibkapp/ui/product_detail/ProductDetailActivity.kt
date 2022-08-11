package io.kiwik.ibkapp.ui.product_detail

import android.os.Bundle
import androidx.activity.viewModels
import io.kiwik.ibkapp.databinding.ActivityProductDetailBinding
import io.kiwik.ibkapp.ui.BaseActivity
import io.kiwik.ibkapp.ui.login.LoginViewModel

class ProductDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}