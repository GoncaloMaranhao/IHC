package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class Tarefa14 : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa14)

        supportActionBar?.apply {
            title = "New schedule"
            setDisplayHomeAsUpEnabled(true)
        }
        findViewById<Button>(R.id.submitAppointment).setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.submitAppointment -> {
                val intent = Intent(this, Tarefa15::class.java)
                startActivity(intent)
            }
            else -> {}
        }
    }
}