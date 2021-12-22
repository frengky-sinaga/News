package com.salve.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salve.news.base.BaseFragment
import com.salve.news.databinding.FragmentSearchBinding
import timber.log.Timber

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("SearchFragment called")
    }
}