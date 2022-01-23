package com.salve.common.core.domain.use_case

import com.salve.common.core.domain.model.Article
import com.salve.common.core.domain.utils.NewsCategory
import com.salve.common.core.domain.utils.NewsCountry
import com.salve.common.core.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getTopHeadlines(
        country: NewsCountry = NewsCountry.UNITED_STATES,
        category: NewsCategory = NewsCategory.GENERAL,
    ): Flow<Resource<List<Article>>>

    fun getBookmarksArticle(): Flow<List<Article>>

    fun setBookmarkArticle(article: Article, newState: Boolean)
}