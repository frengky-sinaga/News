package com.salve.common.core.domain.use_case

import com.salve.common.core.domain.model.Article
import com.salve.common.core.domain.repository.NewsRepository
import com.salve.common.core.domain.utils.NewsCategory
import com.salve.common.core.domain.utils.NewsCountry
import com.salve.common.core.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsUseCaseImpl @Inject constructor(private val newsRepository: NewsRepository) :
    NewsUseCase {
    override fun getTopHeadlines(
        country: NewsCountry,
        category: NewsCategory,
    ): Flow<Resource<List<Article>>> = newsRepository.getTopHeadlines(country, category)

    override fun getBookmarksArticle(): Flow<List<Article>> = newsRepository.getBookmarksArticle()

    override fun setBookmarkArticle(article: Article, newState: Boolean) =
        newsRepository.setBookmarkArticle(article, newState)
}