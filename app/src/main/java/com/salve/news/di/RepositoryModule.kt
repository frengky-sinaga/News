package com.salve.news.di

import com.salve.common.core.data.cache.data_source.NewsLocalDataSource
import com.salve.common.core.data.network.data_source.NewsRemoteDataSource
import com.salve.common.core.data.repository.AppExecutors
import com.salve.common.core.data.repository.news.NewsRepositoryImpl
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
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository =
        NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource, AppExecutors())
}