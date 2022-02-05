package com.salve.common.core.data.repository.news

import com.salve.common.core.data.cache.data_source.NewsLocalDataSource
import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.data.network.data_source.NewsRemoteDataSource
import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.data.network.utils.ApiResponse
import com.salve.common.core.data.repository.AppExecutors
import com.salve.common.core.data.repository.NetworkBoundResource
import com.salve.common.core.domain.mapper.MapperAllLayers
import com.salve.common.core.domain.model.Article
import com.salve.common.core.domain.repository.NewsRepository
import com.salve.common.core.domain.utils.NewsCategory
import com.salve.common.core.domain.utils.NewsCountry
import com.salve.common.core.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    private val appExecutors: AppExecutors,
    private val mapper: MapperAllLayers<Article, ArticleEntity, ArticleDto>
) : NewsRepository {
    override fun getTopHeadlines(
        country: NewsCountry,
        category: NewsCategory,
    ): Flow<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, List<ArticleDto>>() {
            override fun loadFromDB(): Flow<List<Article>> =
                newsLocalDataSource.getTopHeadlines().map { list ->
                    list.map { entity -> mapper.entityToDomain().map(entity) }
                }

            override fun shouldFetch(data: List<Article>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<ArticleDto>>> =
                newsRemoteDataSource.getTopHeadlines(country.countryCode, category.categoryName)

            override suspend fun saveCallResult(data: List<ArticleDto>) {
                val newArticles = data.map { mapper.dtoToEntity().map(it) }
                newsLocalDataSource.insertTopHeadlines(newArticles)
            }

        }.asFlow()

    override fun getBookmarksArticle(): Flow<List<Article>> =
        newsLocalDataSource.getBookmarksArticle().map { list ->
            list.map { entity -> mapper.entityToDomain().map(entity) }
        }

    override fun setBookmarkArticle(article: Article, newState: Boolean) {
        appExecutors.diskIO().execute {
            newsLocalDataSource.setBookmarkArticle(mapper.domainToEntity().map(article), newState)
        }
    }

    override fun deleteAllData() {
        appExecutors.diskIO().execute {
            newsLocalDataSource.deleteAllData()
        }
    }
}