package io.kiwik.ibkapp.ui.home.operations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.kiwik.ibkapp.databinding.FragmentDashboardBinding

class OperationsFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: OperationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[OperationsViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        setViewModel()
    }
}