package com.salve.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.salve.news.common.base.BaseDialogFragment
import com.salve.settings.databinding.DialogSettingsBinding

class SettingsDialog : BaseDialogFragment<DialogSettingsBinding>() {
    companion object {
        fun newInstance(title: String, requestKey: String) = SettingsDialog().apply {
            arguments = Bundle().apply {
                putString(EXTRA_TITLE, title)
                putString(REQUEST_KEY, requestKey)
            }
        }

        const val TAG = "SettingsDialog"
        private const val EXTRA_TITLE = "extraTitle"
        private const val REQUEST_KEY = "requestKey"
    }

    enum class Result {
        OKAY,
        CANCELLED,
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DialogSettingsBinding = DialogSettingsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(EXTRA_TITLE) ?: getString(R.string.do_you_want_to_proceed)
        binding.textView.text = arguments?.getString(EXTRA_TITLE) ?: title

        val requestKey = arguments?.getString(REQUEST_KEY) ?: TAG
        binding.buttonPrimary.setOnClickListener {
            setResult(requestKey, Result.OKAY)
            dismiss()
        }
        binding.buttonSecondary.setOnClickListener {
            setResult(requestKey, Result.CANCELLED)
            dismiss()
        }

        isCancelable = false
    }

    private fun setResult(requestKey: String, result: Result) {
        setFragmentResult(requestKey, bundleOf(TAG to result))
    }
}