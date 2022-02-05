package com.salve.news.di.cache

import android.content.Context
import androidx.room.Room
import com.salve.common.core.data.cache.data_source.NewsLocalDataSource
import com.salve.common.core.data.cache.data_source.NewsLocalDataSourceImpl
import com.salve.common.core.data.cache.database.AppDatabase
import com.salve.common.core.data.cache.database.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "NewsApp.db")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideNewsDao(database: AppDatabase): NewsDao = database.newsDao()

    @Provides
    @Singleton
    fun provideNewsLocalDataSource(newsDao: NewsDao): NewsLocalDataSource =
        NewsLocalDataSourceImpl(newsDao)
}