package com.example.babbysitease

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa33Binding
import java.util.Locale

class Tarefa33 : AppCompatActivity() {

private lateinit var binding: ActivityTarefa33Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityTarefa33Binding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa33)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

      supportActionBar?.apply {
          title = "Conversations"
          setDisplayHomeAsUpEnabled(true)
      }

        val clientInfoButton5: Button = findViewById(R.id.clientInfoButton5)
        val clientInfoButton6: Button = findViewById(R.id.clientInfoButton6)
        val clientInfoButton7: Button = findViewById(R.id.clientInfoButton7)
        val clientInfoButton8: Button = findViewById(R.id.clientInfoButton8)

        val button = findViewById<Button>(R.id.clientInfoButton5)
        val text = "Child: Ana Carvalho \n" + " Caregiver: João / Sofia"
        val spannable = SpannableString(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        button.text = spannable

        val button2 = findViewById<Button>(R.id.clientInfoButton6)
        val text2 = "Child: Catarina Mendes \n Caregiver: Carlos"
        val spannable2 = SpannableString(text2)
        spannable2.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        button2.text = spannable2

        val button3 = findViewById<Button>(R.id.clientInfoButton7)
        val text3 = "Child: João Otávio \n Caregiver: Paulo / Susana"
        val spannable3 = SpannableString(text3)
        spannable3.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        button3.text = spannable3

        val button4 = findViewById<Button>(R.id.clientInfoButton8)
        val text4 = "Child: Manuel Alemida \n Caregiver: António / Sara"
        val spannable4 = SpannableString(text4)
        spannable4.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        button4.text = spannable4

      val client1Name = "A"
      val client2Name = "C"
        val client3Name = "J"
        val client4Name = "P"

      val firstLetter1: TextView = binding.firstLetter5
      val firstLetter2: TextView = binding.firstLetter6
        val firstLetter3: TextView = binding.firstLetter7
        val firstLetter4: TextView = binding.firstLetter8



        firstLetter1.text = client1Name.first().uppercase(Locale.getDefault())
      firstLetter2.text = client2Name.first().uppercase(Locale.getDefault())
        firstLetter3.text = client3Name.first().uppercase(Locale.getDefault())
        firstLetter4.text = client4Name.first().uppercase(Locale.getDefault())

      firstLetter1.setTextColor(ContextCompat.getColor(this, android.R.color.white))
      firstLetter2.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        firstLetter3.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        firstLetter4.setTextColor(ContextCompat.getColor(this, android.R.color.white))


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            clientInfoButton7.text = Html.fromHtml("<b><u>Caregiver</b></u>: João / Sofia \n Child: Ana Carvalho  ", Html.FROM_HTML_MODE_LEGACY)
            clientInfoButton6.text = Html.fromHtml("<b><u>Caregiver</b></u>: Gonçalo \n Child: Catarina Mendes ", Html.FROM_HTML_MODE_LEGACY)
            clientInfoButton8.text = Html.fromHtml("<b><u>Caregiver</b></u>: Paulo / Rosa \n Child: João Otávio ", Html.FROM_HTML_MODE_LEGACY)
            clientInfoButton5.text = Html.fromHtml("<b><u>Caregiver</b></u>: António / Sara \n Child: Manuel Almeida ", Html.FROM_HTML_MODE_LEGACY)
        }


      binding.clientInfoButton5.setOnClickListener {
        val intent = Intent(this, Tarefa34::class.java)
        startActivity(intent)
      }

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

    }

  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa32::class.java)
    startActivity(intent)
    finish()
    return true
  }
}

