package com.salve.common.core.data.network.model

data class TopHeadlinesDto(
    val status: String,

    //only show when succeed
    val totalResults: Int?,
    val articles: List<ArticleDto>?,

    //only show when error
    val code: String?,
    val message: String?
)