package com.salve.news.dfm.favorites.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.salve.news.common.base.BaseFragment
import com.salve.news.dfm.favorites.databinding.FragmentFavoritesBinding
import com.salve.news.dfm.favorites.di.DaggerFavoritesComponent
import com.salve.news.di.DfmFavoritesModule
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    @Inject
    lateinit var viewModel: FavoritesViewModel
    private var favoritesAdapter: FavoritesAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoritesComponent.builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context,
                    DfmFavoritesModule::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.getArticleBookmarks.observe(viewLifecycleOwner) {
            favoritesAdapter?.setContents(it)
        }
    }

    private fun setupRecyclerView() {
        favoritesAdapter = FavoritesAdapter()
        binding.recyclerViewNews.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = favoritesAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favoritesAdapter = null
    }
}