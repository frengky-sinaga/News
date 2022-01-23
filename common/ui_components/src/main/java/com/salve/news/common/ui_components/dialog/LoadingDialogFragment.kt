package com.salve.news.common.ui_components.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.salve.news.common.ui_components.R
import com.salve.news.common.ui_components.databinding.DialogFragmentLoadingBinding

class LoadingDialogFragment : DialogFragment(R.layout.dialog_fragment_loading) {

    companion object {
        fun newInstance() = LoadingDialogFragment()

        const val TAG = "LoadingDialogFragment"
    }

    override fun getTheme(): Int = R.style.DialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = DialogFragmentLoadingBinding.bind(view)
        binding.lottieAnimation.speed = 1.2f

        dialog?.setCancelable(false)
    }
}