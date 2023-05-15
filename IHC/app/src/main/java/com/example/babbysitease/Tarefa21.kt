package com.example.babbysitease

import android.content.Intent
import android.os.Bundle
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
    }

  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa32::class.java)
    startActivity(intent)
    finish()
    return true
  }
}
