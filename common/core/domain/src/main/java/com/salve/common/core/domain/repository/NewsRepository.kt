package com.salve.common.core.domain.repository

import com.salve.common.core.domain.model.Article
import com.salve.common.core.domain.utils.Resource
import com.salve.common.core.domain.utils.NewsCategory
import com.salve.common.core.domain.utils.NewsCountry
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopHeadlines(
        country: NewsCountry = NewsCountry.GLOBAL,
        category: NewsCategory = NewsCategory.GENERAL,
    ): Flow<Resource<List<Article>>>

    fun getBookmarksArticle(): Flow<List<Article>>

    fun setBookmarkArticle(article: Article, newState: Boolean)
}