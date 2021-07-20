package com.example.xcriticalapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xcriticalapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : AppCompatActivity() {

   private val navController by lazy{findNavController(R.id.fragmentNavHost)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        setupBottomNavMenu(navController)
    }

   private fun setupBottomNavMenu(navController: NavController) {
       val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
       bottomNav?.setupWithNavController(navController)
    }
}