package com.salve.common.core.domain.model

import java.io.Serializable

data class Article(
    val id: Int,
    val author: String,
    val title: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val url: String,
    val urlToImage: String,
    val isBookmarked: Boolean
) : Serializable
