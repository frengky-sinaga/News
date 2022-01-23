package com.salve.features.news.detail

import androidx.lifecycle.ViewModel
import com.salve.common.core.domain.model.Article
import com.salve.common.core.domain.use_case.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val newsUseCase: NewsUseCase) :
    ViewModel() {
    fun updateBookmark(article: Article, newState: Boolean) =
        newsUseCase.setBookmarkArticle(article, newState)
}