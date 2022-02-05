package com.salve.news.di

import com.salve.common.core.domain.repository.NewsRepository
import com.salve.common.core.domain.use_case.NewsUseCaseImpl
import com.salve.common.core.domain.use_case.NewsUseCase
import com.salve.common.core.domain.use_case.SettingsUseCase
import com.salve.common.core.domain.use_case.SettingsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository): NewsUseCase =
        NewsUseCaseImpl(newsRepository)

    @Provides
    @Singleton
    fun provideSettingsUseCase(newsRepository: NewsRepository): SettingsUseCase =
        SettingsUseCaseImpl(newsRepository)
}