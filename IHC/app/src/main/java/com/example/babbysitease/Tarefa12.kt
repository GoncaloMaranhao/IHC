package com.example.babbysitease

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa12Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.Locale
import android.widget.Toast
import android.widget.CalendarView


class Tarefa12 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa12Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Select a client"
            setDisplayHomeAsUpEnabled(true)
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa12)
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

        val button = findViewById<Button>(R.id.clientInfoButton2)
        val text = "Child: Catarina Mendes \n Parents: Carlos/Sofia"
        val spannable = SpannableString(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        button.text = spannable

        val button2 = findViewById<Button>(R.id.clientInfoButton)
        val text2 = "Child: Ana Carvalho \n Parents: João/Sofia"
        val spannable2 = SpannableString(text2)
        spannable2.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        button2.text = spannable2

        val client1Name = "Ana"
        val client2Name = "Catarina"

        val firstLetter1: TextView = binding.firstLetter1
        val firstLetter2: TextView = binding.firstLetter2

        firstLetter1.text = client1Name.first().uppercase(Locale.getDefault())
        firstLetter2.text = client2Name.first().uppercase(Locale.getDefault())

        firstLetter1.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        firstLetter2.setTextColor(ContextCompat.getColor(this, android.R.color.white))


        binding.clientInfoButton.setOnClickListener {
            val intent = Intent(this, Tarefa13::class.java)
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
        val intent = Intent(this, Tarefa11_1::class.java)
        startActivity(intent)
        finish()
        return true
    }
}
