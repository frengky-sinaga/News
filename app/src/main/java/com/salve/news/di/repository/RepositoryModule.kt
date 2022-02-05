package com.salve.news.di.repository

import com.salve.common.core.data.cache.data_source.NewsLocalDataSource
import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.data.network.data_source.NewsRemoteDataSource
import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.data.repository.AppExecutors
import com.salve.common.core.data.repository.news.NewsRepositoryImpl
import com.salve.common.core.domain.mapper.MapperAllLayers
import com.salve.common.core.domain.model.Article
import com.salve.common.core.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource,
        mapper: MapperAllLayers<Article, ArticleEntity, ArticleDto>
    ): NewsRepository =
        NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource, AppExecutors(), mapper)
}