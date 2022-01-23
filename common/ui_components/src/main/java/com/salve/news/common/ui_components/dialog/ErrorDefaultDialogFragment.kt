package com.salve.news.common.ui_components.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.salve.news.common.ui_components.R
import com.salve.news.common.ui_components.databinding.DialogFragmentErrorDefaultBinding

class ErrorDefaultDialogFragment : DialogFragment(R.layout.dialog_fragment_error_default) {

    companion object {
        fun newInstance(errorMessage: String) = ErrorDefaultDialogFragment().apply {
            arguments = Bundle().apply {
                putString(ERROR_MESSAGE, errorMessage)
            }
        }

        const val TAG = "LoadingDialogFragment"
        private const val ERROR_MESSAGE = "errorMessage"
    }

    override fun getTheme(): Int = R.style.DialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = DialogFragmentErrorDefaultBinding.bind(view)
        binding.lottieAnimation.speed = 1.2f

        arguments?.getString(ERROR_MESSAGE)?.let {
            binding.errorMessage.text = it
        }
    }
}