package com.example.babbysitease

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa24Binding
import android.view.inputmethod.EditorInfo
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import kotlin.math.roundToInt

class Tarefa24 : AppCompatActivity() {

  private lateinit var binding: ActivityTarefa24Binding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityTarefa24Binding.inflate(layoutInflater)
    setContentView(binding.root)

    val navView = binding.navView

    val navController = findNavController(R.id.nav_host_fragment_activity_tarefa24)
    val appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
      )
    )
    setupActionBarWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)

    val doneButton = findViewById<Button>(R.id.doneButton)
    doneButton.visibility = View.GONE
    doneButton.setOnClickListener {
      val imm = it.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      imm.hideSoftInputFromWindow(it.windowToken, 0)

      it.postDelayed({
        it.visibility = View.INVISIBLE
      }, 100) // 100ms delay
    }

    KeyboardVisibilityEvent.setEventListener(this, object : KeyboardVisibilityEventListener {
      override fun onVisibilityChanged(isOpen: Boolean) {
        if (isOpen) {
          doneButton.visibility = View.VISIBLE
        } else {
          doneButton.visibility = View.GONE
        }
      }
    })

    binding.saveButton.setOnClickListener {
      val intent = Intent(this, Tarefa25::class.java)
      startActivity(intent)
    }

    supportActionBar?.apply {
      title = "Allergies"
      setDisplayHomeAsUpEnabled(true)
    }
  }
  override fun onSupportNavigateUp(): Boolean {
    val intent = Intent(this, Tarefa23::class.java)
    startActivity(intent)
    finish()
    return true
  }
}
