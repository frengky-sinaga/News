package com.salve.news.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<ViewBindingType : ViewBinding> : DialogFragment() {

    private var _binding: ViewBindingType? = null
    protected val binding get() = _binding!!

    abstract fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewBindingType

    override fun getTheme(): Int = R.style.DialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}