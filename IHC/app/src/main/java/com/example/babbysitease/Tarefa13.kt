package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.babbysitease.databinding.ActivityTarefa13Binding
import java.util.Locale

class Tarefa13 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa13Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa13)

        binding = ActivityTarefa13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Select Client"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.clientInfoButton.setOnClickListener {
            val intent = Intent(this, Tarefa14::class.java)
            startActivity(intent)
        }

      val client1Name = "Ana"
      val client2Name = "Catarina"

      val firstLetter1: TextView = binding.firstLetter1
      val firstLetter2: TextView = binding.firstLetter2

      firstLetter1.text = client1Name.first().uppercase(Locale.getDefault())
      firstLetter2.text = client2Name.first().uppercase(Locale.getDefault())

      firstLetter1.setTextColor(ContextCompat.getColor(this, android.R.color.white))
      firstLetter2.setTextColor(ContextCompat.getColor(this, android.R.color.white))
    }



    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, Tarefa12::class.java)
        startActivity(intent)
        finish()
        return true
    }
}
