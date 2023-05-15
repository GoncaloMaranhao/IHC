package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ScrollView


class Tarefa11 : AppCompatActivity(), OnClickListener {
    private lateinit var preferences: SharedPreferences
    private lateinit var scrollView: ScrollView
    private lateinit var newAppointmentButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa11)

        preferences = applicationContext.getSharedPreferences("my_preferences", MODE_PRIVATE)
        scrollView = findViewById(R.id.appointmentsScrollView)
        newAppointmentButton = findViewById((R.id.newAppointmentButton))
        newAppointmentButton.setOnClickListener(this)

        addAllAppointments(scrollView)
    }

    private fun addAllAppointments(view: ScrollView) {
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.newAppointmentButton -> {
                val intent = Intent(this, Tarefa12::class.java)
                navigateUpTo(intent)
            }
            else -> {}
        }
    }
}
