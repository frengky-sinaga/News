package com.salve.news.di

import com.salve.navigation.Navigation
import com.salve.news.navigation.NavigationImpl
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