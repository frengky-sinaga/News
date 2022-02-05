package com.salve.common.core.data.repository.mapper

import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.domain.mapper.Mapper
import com.salve.common.core.domain.mapper.MapperAllLayers
import com.salve.common.core.domain.model.Article
import javax.inject.Inject

class NewsMapperImpl @Inject constructor(
    private val domainToEntity: Mapper<Article, ArticleEntity>,
    private val entityToDomain: Mapper<ArticleEntity, Article>,
    private val dtoToEntity: Mapper<ArticleDto, ArticleEntity>
) : MapperAllLayers<Article, ArticleEntity, ArticleDto> {
    override fun domainToEntity(): Mapper<Article, ArticleEntity> = domainToEntity
    override fun entityToDomain(): Mapper<ArticleEntity, Article> = entityToDomain
    override fun dtoToEntity(): Mapper<ArticleDto, ArticleEntity> = dtoToEntity
}