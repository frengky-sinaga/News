package com.salve.common.core.data.cache.database

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.salve.common.core.data.cache.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @RawQuery(observedEntities = [ArticleEntity::class])
    fun getTopHeadlines(query: SupportSQLiteQuery): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTopHeadlines(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles_table WHERE isBookmarked = 1")
    fun getBookmarksArticle(): Flow<List<ArticleEntity>>

    @Update
    fun updateBookmarksArticle(article: ArticleEntity)

    @Query("DELETE FROM articles_table")
    fun deleteAllData()
}