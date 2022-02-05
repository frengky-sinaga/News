package com.salve.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.salve.news.common.base.BaseFragment
import com.salve.settings.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    private val viewModel: SettingsViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clearCache.setOnClickListener {
            clearCache()
        }

        binding.changeLanguage.setOnClickListener {
            changeLanguage()
        }
    }

    private fun changeLanguage() {
        val requestKey = "ChangeLanguage"
        val tag = SettingsDialog.TAG

        childFragmentManager.setFragmentResultListener(
            requestKey,
            viewLifecycleOwner
        ) { _, bundle ->
            val result = bundle.getSerializable(tag) as SettingsDialog.Result
            if (result == SettingsDialog.Result.OKAY) {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings")
                startActivity(intent)
            }
        }

        val text =
            "${getString(R.string.do_you_want_to_change_language)}\n${getString(R.string.currently_indonesia_not_supported)}"
        val dialog = SettingsDialog.newInstance(text, requestKey)
        dialog.show(childFragmentManager, tag)
    }

    private fun clearCache() {
        val requestKey = "ClearCache"
        val tag = SettingsDialog.TAG

        childFragmentManager.setFragmentResultListener(
            requestKey,
            viewLifecycleOwner
        ) { _, bundle ->
            val result = bundle.getSerializable(tag) as SettingsDialog.Result
            if (result == SettingsDialog.Result.OKAY) viewModel.clearCache()
        }

        val dialog = SettingsDialog.newInstance(
            getString(R.string.do_you_want_to_clear_cache), requestKey
        )
        dialog.show(childFragmentManager, tag)
    }
}