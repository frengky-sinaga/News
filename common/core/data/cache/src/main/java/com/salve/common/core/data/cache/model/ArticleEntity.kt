package com.salve.common.core.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles_table")
data class ArticleEntity(
    val author: String,
    @PrimaryKey val title: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val url: String,
    val urlToImage: String,
    var isBookmarked: Boolean = false
)
