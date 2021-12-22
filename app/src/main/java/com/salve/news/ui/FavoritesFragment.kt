package com.salve.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salve.news.base.BaseFragment
import com.salve.news.databinding.FragmentFavoritesBinding
import timber.log.Timber

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("FavoritesFragment called")
    }
}