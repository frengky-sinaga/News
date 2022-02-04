package com.salve.news.di

import com.salve.common.core.domain.use_case.NewsUseCase
import com.salve.navigation.Navigation
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DfmFavoritesModule {

    fun newsUseCase(): NewsUseCase
    fun navigationDetail(): Navigation
}