package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.navigation.Navigation

class Tarefa12 : AppCompatActivity(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa12)

        supportActionBar?.apply {
            title = "New Schedule"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.selectClientTextView -> {
                val intent = Intent(this, Tarefa13::class.java)
                startActivity(intent)
            }
            else -> {}
        }
    }
}
