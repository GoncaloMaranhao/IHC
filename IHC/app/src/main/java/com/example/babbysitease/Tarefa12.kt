package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.babbysitease.databinding.ActivityTarefa12Binding

class Tarefa12 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa12Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa12)

        binding = ActivityTarefa12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelectClient.setOnClickListener {
            val intent = Intent(this, Tarefa13::class.java)
            startActivity(intent)
        }

        supportActionBar?.apply {
            title = "New Appointment"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, Tarefa11::class.java)
        startActivity(intent)
        finish()
        return true
    }
}
