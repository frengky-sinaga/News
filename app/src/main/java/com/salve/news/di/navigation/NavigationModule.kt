package com.salve.news.di.navigation

import com.salve.navigation.Navigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {
    @Provides
    fun provideNavigationDetail(): Navigation = NavigationImpl()
}