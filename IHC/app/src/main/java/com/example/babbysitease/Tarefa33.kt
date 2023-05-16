package com.example.babbysitease

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa33Binding
import java.util.Locale

class Tarefa33 : AppCompatActivity() {

private lateinit var binding: ActivityTarefa33Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityTarefa33Binding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa33)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

      supportActionBar?.apply {
          title = "Conversations"
          setDisplayHomeAsUpEnabled(true)
      }

      val client1Name = "Ana"
      val client2Name = "Catarina"

      val firstLetter1: TextView = binding.firstLetter1
      val firstLetter2: TextView = binding.firstLetter2

      firstLetter1.text = client1Name.first().uppercase(Locale.getDefault())
      firstLetter2.text = client2Name.first().uppercase(Locale.getDefault())

      firstLetter1.setTextColor(ContextCompat.getColor(this, android.R.color.white))
      firstLetter2.setTextColor(ContextCompat.getColor(this, android.R.color.white))

      binding.clientInfoButton.setOnClickListener {
        val intent = Intent(this, Tarefa34::class.java)
        startActivity(intent)
      }

      navView.setOnNavigationItemSelectedListener { item ->
        when (item.itemId) {
          R.id.navigation_home -> {
            val intent = Intent(this, Tarefa32::class.java)
            startActivity(intent)
            true
          }
          R.id.navigation_dashboard -> {
            navController.navigate(R.id.navigation_dashboard)
            val intent = Intent(this, Tarefa11::class.java)
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

    }

  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa32::class.java)
    startActivity(intent)
    finish()
    return true
  }
}

