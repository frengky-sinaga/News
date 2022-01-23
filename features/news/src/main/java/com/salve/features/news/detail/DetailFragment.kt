package com.salve.features.news.detail

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import coil.size.Scale
import com.salve.common.core.domain.model.Article
import com.salve.common.utility.DateFormatUtils
import com.salve.common.utility.byUsingHtml
import com.salve.features.news.R
import com.salve.features.news.databinding.FragmentDetailBinding
import com.salve.news.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var article: Article
    private var bookmarkStatus: Boolean = false

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        article = DetailFragmentArgs.fromBundle(arguments as Bundle).detailArgs
        bookmarkStatus = article.isBookmarked

        binding.author.text = article.author
        binding.description.text = article.description
        binding.title.text = article.title
        binding.publishedTime.text = DateFormatUtils.returnDateText(article.publishedAt)
        binding.image.load(article.urlToImage) {
            crossfade(true)
            crossfade(500)
            placeholder(R.drawable.ic_loading_image)
            error(R.drawable.ic_error_load_image)
            scale(Scale.FILL)
        }
        setupToolbar()
        updateIconToolbar()
        setupLinkSource()
    }

    private fun setupLinkSource() {
        val readFromSource = getString(R.string.read_full_from_source)
        val text = "<a href=\"${article.url}\">$readFromSource</a>"
        binding.source.apply {
            movementMethod = LinkMovementMethod.getInstance()
            this.text = text.byUsingHtml()
        }
    }

    private fun setupToolbar() {
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener { requireActivity().onBackPressed() }
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.itemBookmark -> {
                        bookmarkStatus = !bookmarkStatus
                        updateIconToolbar()
                        viewModel.updateBookmark(article, bookmarkStatus)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun updateIconToolbar() {
        val bookmarkItem = binding.toolbar.menu.findItem(R.id.itemBookmark)
        val icon =
            if (bookmarkStatus) R.drawable.ic_bookmark_active else R.drawable.ic_bookmark_default
        bookmarkItem.setIcon(icon)
    }
}