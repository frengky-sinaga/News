package com.salve.features.news.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.salve.common.core.domain.utils.Resource
import com.salve.features.news.R
import com.salve.features.news.databinding.FragmentHomeBinding
import com.salve.news.common.base.BaseFragment
import com.salve.news.common.ui_components.dialog.ErrorDefaultDialogFragment
import com.salve.news.common.ui_components.dialog.LoadingDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()
    private var homeAdapter: HomeAdapter? = null

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        //setupToolbar()

        viewModel.getTopHeadlines.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    hideLoading()
                    Timber.d("${it.data}")
                    it.data?.let { contents -> homeAdapter?.setContents(contents) }
                }
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Error -> {
                    hideLoading()
                    val errorDialog = ErrorDefaultDialogFragment.newInstance(it.message.toString())
                    errorDialog.show(childFragmentManager, ErrorDefaultDialogFragment.TAG)
                }
            }
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.itemCollectionsBookmark -> {
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        homeAdapter = HomeAdapter()
        binding.recyclerViewNews.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }
    }

    private fun showLoading() {
        val loadingDialogFragment =
            childFragmentManager.findFragmentByTag(LoadingDialogFragment.TAG)
        if (loadingDialogFragment == null) {
            val loadingDialog = LoadingDialogFragment.newInstance()
            loadingDialog.show(childFragmentManager, LoadingDialogFragment.TAG)
        }
    }

    private fun hideLoading() {
        val loadingDialogFragment =
            childFragmentManager.findFragmentByTag(LoadingDialogFragment.TAG)
        if (loadingDialogFragment != null) {
            childFragmentManager.beginTransaction().remove(loadingDialogFragment)
                .commitAllowingStateLoss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homeAdapter = null
    }
}