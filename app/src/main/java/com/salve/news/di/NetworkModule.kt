package com.salve.news.di

import com.salve.common.core.data.network.data_source.NewsRemoteDataSource
import com.salve.common.core.data.network.data_source.NewsRemoteDataSourceImpl
import com.salve.common.core.data.network.service.NewsService
import com.salve.common.core.data.network.service.ServiceBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideNewsService(): NewsService = ServiceBuilder.build(NewsService::class.java)

    @Provides
    @Singleton
    fun provideNewsDataSource(newsService: NewsService): NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(newsService)
}