package com.example.xcriticalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class Navigation : AppCompatActivity() {

   private val navController by lazy{ findNavController(R.id.fragmentNavHost)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setupBottomNavMenu(navController)
    }

   private fun setupBottomNavMenu(navController: NavController) {
       val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
       bottomNav?.setupWithNavController(navController)
    }
}