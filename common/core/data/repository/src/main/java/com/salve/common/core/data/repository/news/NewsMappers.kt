package com.salve.common.core.data.repository.news

import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.domain.model.Article

internal fun ArticleDto.toEntity() = ArticleEntity(
    id = 0,
    author = this.author ?: "Unknown",
    title = this.title,
    content = this.content ?: "",
    description = this.description ?: "",
    publishedAt = this.publishedAt,
    source = this.source.name,
    url = this.url,
    urlToImage = this.urlToImage ?: "",
    isBookmarked = false
)

internal fun ArticleEntity.toDomain() = Article(
    id, author, title, content, description, publishedAt, source, url, urlToImage, isBookmarked
)

internal fun List<ArticleEntity>.toDomain(): List<Article> =
    this.map { it.toDomain() }

internal fun Article.toEntity() = ArticleEntity(
    id, author, title, content, description, publishedAt, source, url, urlToImage, isBookmarked
)