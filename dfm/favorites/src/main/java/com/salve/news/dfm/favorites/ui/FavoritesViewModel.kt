package com.salve.news.dfm.favorites.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.salve.common.core.domain.use_case.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(useCase: NewsUseCase) : ViewModel() {
    val getArticleBookmarks = useCase.getBookmarksArticle().asLiveData()
}
