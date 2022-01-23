package com.salve.common.core.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salve.common.core.data.cache.model.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}