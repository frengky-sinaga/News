package com.salve.news.di.repository

import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.data.repository.mapper.MapArticleDtoToEntity
import com.salve.common.core.data.repository.mapper.MapArticleEntityToDomain
import com.salve.common.core.data.repository.mapper.MapArticleToEntity
import com.salve.common.core.data.repository.mapper.NewsMapperImpl
import com.salve.common.core.domain.mapper.Mapper
import com.salve.common.core.domain.mapper.MapperAllLayers
import com.salve.common.core.domain.model.Article
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Mapper {
    @Provides
    @Singleton
    fun provideMapArticleToEntity(): Mapper<Article, ArticleEntity> = MapArticleToEntity()

    @Provides
    @Singleton
    fun provideMapArticleEntityToDomain(): Mapper<ArticleEntity, Article> =
        MapArticleEntityToDomain()

    @Provides
    @Singleton
    fun provideMapArticleDtoToEntity(): Mapper<ArticleDto, ArticleEntity> = MapArticleDtoToEntity()

    @Provides
    @Singleton
    fun provideNewsMapper(
        domainToEntity: Mapper<Article, ArticleEntity>,
        entityToDomain: Mapper<ArticleEntity, Article>,
        dtoToEntity: Mapper<ArticleDto, ArticleEntity>
    ): MapperAllLayers<Article, ArticleEntity, ArticleDto> =
        NewsMapperImpl(domainToEntity, entityToDomain, dtoToEntity)
}