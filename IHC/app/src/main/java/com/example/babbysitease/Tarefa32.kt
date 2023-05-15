package com.example.babbysitease

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa32Binding

class Tarefa32 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa32Binding

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      binding = ActivityTarefa32Binding.inflate(layoutInflater)
      setContentView(binding.root)

      val navView: BottomNavigationView = binding.navView

      val navController = findNavController(R.id.nav_host_fragment_activity_tarefa32)
      val appBarConfiguration = AppBarConfiguration(
        setOf(
          R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
        )
      )
      setupActionBarWithNavController(navController, appBarConfiguration)
      navView.setupWithNavController(navController)

      supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(true)
      }

      binding.btnConversations.setOnClickListener {
        val intent = Intent(this, Tarefa33::class.java)
        startActivity(intent)
      }
      binding.btnClientsInformation.setOnClickListener {
        val intent = Intent(this, Tarefa21::class.java)
        startActivity(intent)
      }
    }
}
