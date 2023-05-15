package com.example.babbysitease

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa26Binding

class Tarefa26 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa26Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa26Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa26)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

      navView.setOnNavigationItemSelectedListener { item ->
        when (item.itemId) {
          R.id.navigation_home -> {
            val intent = Intent(this, Tarefa32::class.java)
            startActivity(intent)
            true
          }
          R.id.navigation_dashboard -> {
            navController.navigate(R.id.navigation_dashboard)
            val intent = Intent(this, Tarefa32::class.java)
            startActivity(intent)
            true
          }
          R.id.navigation_notifications -> {
            navController.navigate(R.id.navigation_notifications)
            val intent = Intent(this, Tarefa33::class.java)
            startActivity(intent)
            true
          }
          else -> false
        }
      }

      supportActionBar?.apply {
        title = "Information"
        setDisplayHomeAsUpEnabled(true)
      }

      binding.saveChangesButton.setOnClickListener {
        val intent = Intent(this, Tarefa32::class.java)
        startActivity(intent)
      }

    }

  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa25::class.java)
    startActivity(intent)
    finish()
    return true
  }
}
