package com.salve.navigation

import android.os.Bundle
import androidx.navigation.NavController

interface Navigation {
    fun toDetail(navController: NavController, bundle: Bundle)
}