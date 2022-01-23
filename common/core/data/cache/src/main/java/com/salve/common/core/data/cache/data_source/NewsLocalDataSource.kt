package com.salve.common.core.data.cache.data_source

import com.salve.common.core.data.cache.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    fun getTopHeadlines(): Flow<List<ArticleEntity>>

    suspend fun insertTopHeadlines(articles: List<ArticleEntity>)

    fun getBookmarksArticle(): Flow<List<ArticleEntity>>

    fun setBookmarkArticle(article: ArticleEntity, newState: Boolean)
}