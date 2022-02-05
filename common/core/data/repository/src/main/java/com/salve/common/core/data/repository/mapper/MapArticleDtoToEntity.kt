package com.salve.common.core.data.repository.mapper

import com.salve.common.core.data.cache.model.ArticleEntity
import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.domain.mapper.Mapper

class MapArticleDtoToEntity : Mapper<ArticleDto, ArticleEntity> {
    override fun map(input: ArticleDto) = ArticleEntity(
        author = input.author ?: "Unknown",
        title = input.title,
        content = input.content ?: "",
        description = input.description ?: "",
        publishedAt = input.publishedAt,
        source = input.source.name,
        url = input.url,
        urlToImage = input.urlToImage ?: "",
        isBookmarked = false
    )
}