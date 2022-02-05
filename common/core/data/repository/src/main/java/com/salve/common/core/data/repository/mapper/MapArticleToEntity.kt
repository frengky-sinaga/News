package com.salve.common.core.data.repository.mapper

import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.domain.mapper.Mapper
import com.salve.common.core.domain.model.Article

class MapArticleToEntity : Mapper<Article, ArticleEntity> {
    override fun map(input: Article) = ArticleEntity(
        author = input.author,
        title = input.title,
        content = input.content,
        description = input.description,
        publishedAt = input.publishedAt,
        source = input.source,
        url = input.url,
        urlToImage = input.urlToImage,
        isBookmarked = input.isBookmarked
    )
}