package com.salve.common.core.data.repository.mapper

import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.domain.mapper.Mapper
import com.salve.common.core.domain.model.Article

class MapArticleEntityToDomain : Mapper<ArticleEntity, Article> {
    override fun map(input: ArticleEntity) = Article(
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