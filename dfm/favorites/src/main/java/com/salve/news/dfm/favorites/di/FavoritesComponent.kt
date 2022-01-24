package com.salve.news.dfm.favorites.di

import android.content.Context
import com.salve.news.dfm.favorites.ui.FavoritesFragment
import com.salve.news.di.DfmFavoritesModule
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [DfmFavoritesModule::class])
interface FavoritesComponent {
    fun inject(fragment: FavoritesFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(dfmFavoritesModule: DfmFavoritesModule): Builder
        fun build(): FavoritesComponent
    }
}