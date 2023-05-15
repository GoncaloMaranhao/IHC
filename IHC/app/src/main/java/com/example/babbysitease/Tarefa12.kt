package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.navigation.Navigation

class Tarefa12 : AppCompatActivity(), OnClickListener {
    private lateinit var scheduleButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa12)

        scheduleButton = findViewById(R.id.scheduleAppointmentButton)
        scheduleButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.scheduleAppointmentButton -> {
                val intent = Intent(this, Tarefa11::class.java)
                navigateUpTo(intent)
            }
            else -> {}
        }
    }
}
