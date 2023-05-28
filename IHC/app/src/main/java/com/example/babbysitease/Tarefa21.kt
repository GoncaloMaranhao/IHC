package com.example.babbysitease

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa21Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.Locale
import android.widget.Toast
import android.widget.CalendarView


class Tarefa21 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa21Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Select a client"
            setDisplayHomeAsUpEnabled(true)
        }

      val clientInfoButton5: Button = findViewById(R.id.clientInfoButton5)
      val clientInfoButton6: Button = findViewById(R.id.clientInfoButton6)
      val clientInfoButton7: Button = findViewById(R.id.clientInfoButton7)
      val clientInfoButton8: Button = findViewById(R.id.clientInfoButton8)


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa21)
        navView.setupWithNavController(navController)

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

      val button = findViewById<Button>(R.id.clientInfoButton5)
      val text = "Child: Catarina Mendes \n Parents: Carlos/Sofia"
      val spannable = SpannableString(text)
      spannable.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      button.text = spannable

      val button2 = findViewById<Button>(R.id.clientInfoButton6)
      val text2 = "Child: Ana Carvalho \n Parents: João/Sofia"
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

        val client1Name = "Ana"
        val client2Name = "Catarina"
      val client3Name = "João"
      val client4Name = "Manuel"

        val firstLetter1: TextView = binding.firstLetter1
        val firstLetter2: TextView = binding.firstLetter2
      val firstLetter3: TextView = binding.firstLetter3
      val firstLetter4: TextView = binding.firstLetter4

        firstLetter1.text = client1Name.first().uppercase(Locale.getDefault())
        firstLetter2.text = client2Name.first().uppercase(Locale.getDefault())
      firstLetter3.text = client3Name.first().uppercase(Locale.getDefault())
      firstLetter4.text = client4Name.first().uppercase(Locale.getDefault())

        firstLetter1.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        firstLetter2.setTextColor(ContextCompat.getColor(this, android.R.color.white))
      firstLetter3.setTextColor(ContextCompat.getColor(this, android.R.color.white))
      firstLetter4.setTextColor(ContextCompat.getColor(this, android.R.color.white))


        binding.clientInfoButton5.setOnClickListener {
            val intent = Intent(this, Tarefa22::class.java)
            startActivity(intent)
        }

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        clientInfoButton5.text = Html.fromHtml("<b><u>Child</b></u>: Ana Carvalho \n Caregiver: João / Sofia", Html.FROM_HTML_MODE_LEGACY)
        clientInfoButton6.text = Html.fromHtml("<b><u>Child</b></u>: Catarina Mendes \n Caregiver: Carlos / Matilde", Html.FROM_HTML_MODE_LEGACY)
        clientInfoButton7.text = Html.fromHtml("<b><u>Child</b></u>: João Otávio \n Caregiver: Paulo / Susana", Html.FROM_HTML_MODE_LEGACY)
        clientInfoButton8.text = Html.fromHtml("<b><u>Child</b></u>: Manuel Alemida \n Caregiver: António / Sara", Html.FROM_HTML_MODE_LEGACY)
      }
    }

  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa32::class.java)
    startActivity(intent)
    finish()
    return true
  }
}
