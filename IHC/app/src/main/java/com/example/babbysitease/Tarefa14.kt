package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.babbysitease.databinding.ActivityTarefa14Binding

class Tarefa14 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa14Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa14)

        binding = ActivityTarefa14Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "New Appointment"
            setDisplayHomeAsUpEnabled(true)
        }

        binding.btnSetAppointment.setOnClickListener {
            val intent = Intent(this, Tarefa15::class.java)
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