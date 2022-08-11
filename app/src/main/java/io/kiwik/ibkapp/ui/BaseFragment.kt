package io.kiwik.ibkapp.ui

import android.content.Intent
import androidx.fragment.app.Fragment
import io.kiwik.data.sharedPreferences.AppSharedPreferencesManager
import io.kiwik.ibkapp.ui.login.LoginActivity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseFragment : Fragment(), KoinComponent {

    private val sharedPreferences by inject<AppSharedPreferencesManager>()

    override fun onResume() {
        super.onResume()
        validateSession()
    }

    private fun validateSession(){
        if (!sharedPreferences.getSession()) {
            activity?.finish()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
    }

}