package com.salve.news.di.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.salve.navigation.Navigation
import com.salve.news.R
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {
    override fun toDetail(navController: NavController, bundle: Bundle) {
        navController.navigate(R.id.detailFragment, bundle)
    }

    override fun toFavorites(navController: NavController) {
        navController.navigate(R.id.favoritesFragment)
    }
}