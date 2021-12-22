package com.salve.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salve.news.base.BaseFragment
import com.salve.news.databinding.FragmentDetailBinding
import timber.log.Timber

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("DetailFragment called")
    }
}