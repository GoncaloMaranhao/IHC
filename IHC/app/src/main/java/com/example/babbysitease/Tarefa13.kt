package com.example.babbysitease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.RelativeLayout

class Tarefa13 : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa13)

        supportActionBar?.apply {
            title = "Clients"
            setDisplayHomeAsUpEnabled(true)
        }
        findViewById<RelativeLayout>(R.id.joaoSofia).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.joaoSofia -> {
                val intent = Intent(this, Tarefa14::class.java)
                startActivity(intent)
            }
            else -> {}
        }
    }
}
