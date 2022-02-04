package com.salve.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salve.news.common.base.BaseFragment
import com.salve.settings.databinding.FragmentSettingsBinding
import timber.log.Timber

//TODO("Add settings")
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