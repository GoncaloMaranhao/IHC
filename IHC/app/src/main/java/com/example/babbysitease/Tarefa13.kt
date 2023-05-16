package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.babbysitease.databinding.ActivityTarefa13Binding

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
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, Tarefa12::class.java)
        startActivity(intent)
        finish()
        return true
    }
}
