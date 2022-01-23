package com.salve.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salve.news.common.base.BaseFragment
import com.salve.news.databinding.FragmentSettingsBinding
import timber.log.Timber

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("Settings called")
    }
}