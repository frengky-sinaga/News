package com.salve.news.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.salve.news.R
import com.salve.news.databinding.ActivityMainBinding
import com.salve.news.common.ui_components.utils.remove
import com.salve.news.common.ui_components.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.itemIconTintList = null
        setNavController()
    }

    private fun setNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(onDestinationChanged)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private val listMainFragments: List<Int> =
        listOf(R.id.homeFragment, R.id.covidFragment, R.id.favoritesFragment)

    private val onDestinationChanged =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            binding.apply {
                if (destination.id in listMainFragments) bottomNavigation.show()
                else bottomNavigation.remove()
            }
        }
}