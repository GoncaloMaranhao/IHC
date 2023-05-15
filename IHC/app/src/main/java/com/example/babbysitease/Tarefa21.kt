package com.example.babbysitease

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa21Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.TextView
import java.util.Locale

class Tarefa21 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa21Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Clients"
            setDisplayHomeAsUpEnabled(true)
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa21)
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

        val client1Name = "Ana"
        val client2Name = "Catarina"

        val firstLetter1: TextView = binding.firstLetter1
        val firstLetter2: TextView = binding.firstLetter2

        firstLetter1.text = client1Name.first().uppercase(Locale.getDefault())
        firstLetter2.text = client2Name.first().uppercase(Locale.getDefault())

        binding.clientInfoButton.setOnClickListener {
            val intent = Intent(this, Tarefa22::class.java)
            startActivity(intent)
        }

      binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
          return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
          if (newText != null) {
            binding.clientAna.visibility = if (newText.lowercase().contains("a")) View.VISIBLE else View.GONE
            binding.clientCatarina.visibility = if (newText.lowercase().contains("c")) View.VISIBLE else View.GONE
          } else {
            binding.clientAna.visibility = View.VISIBLE
            binding.clientCatarina.visibility = View.VISIBLE
          }
          return false
        }
      })

    }

  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa32::class.java)
    startActivity(intent)
    finish()
    return true
  }
}
