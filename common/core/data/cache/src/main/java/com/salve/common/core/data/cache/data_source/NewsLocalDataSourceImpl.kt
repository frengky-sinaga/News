package com.salve.common.core.data.cache.data_source

import com.salve.common.core.data.cache.database.NewsDao
import com.salve.common.core.data.cache.model.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(private val newsDao: NewsDao) :
    NewsLocalDataSource {
    override fun getTopHeadlines(): Flow<List<ArticleEntity>> =
        newsDao.getTopHeadlines(NewsDataSourceUtils.queryLatest())

    override suspend fun insertTopHeadlines(articles: List<ArticleEntity>) =
        newsDao.insertTopHeadlines(articles)

    override fun getBookmarksArticle(): Flow<List<ArticleEntity>> = newsDao.getBookmarksArticle()

    override fun setBookmarkArticle(article: ArticleEntity, newState: Boolean) {
        article.isBookmarked = newState
        newsDao.updateBookmarksArticle(article)
    }

    override fun deleteAllData() = newsDao.deleteAllData()
}