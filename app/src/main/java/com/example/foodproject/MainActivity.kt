package com.example.foodproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main_screen.*

class MainActivity : AppCompatActivity() {

    private var bottomNavigationView:BottomNavigationView? = null
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)

        setUpNavigation()

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.splashScreenFragment, R.id.loginFragment, R.id.registerFragment -> findViewById<BottomNavigationView>(R.id.bottom_nav).visibility = View.INVISIBLE
                else -> findViewById<BottomNavigationView>(R.id.bottom_nav).visibility = View.VISIBLE
            }
        }
    }

    private fun setUpNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_nav)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigationView!!,
            navHostFragment!!.navController
        )
    }
}