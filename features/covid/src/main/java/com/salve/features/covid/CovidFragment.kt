package com.salve.features.covid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salve.features.covid.databinding.FragmentCovidBinding
import com.salve.news.common.base.BaseFragment
import timber.log.Timber

class CovidFragment : BaseFragment<FragmentCovidBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCovidBinding = FragmentCovidBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("SearchFragment called")
    }
}