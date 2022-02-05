package com.salve.common.core.data.cache.database

import androidx.room.*
import com.salve.common.core.data.cache.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM articles_table")
    fun getTopHeadlines(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopHeadlines(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles_table WHERE isBookmarked = 1")
    fun getBookmarksArticle(): Flow<List<ArticleEntity>>

    @Update
    fun updateBookmarksArticle(article: ArticleEntity)

    @Query("DELETE FROM articles_table")
    fun deleteAllData()
}