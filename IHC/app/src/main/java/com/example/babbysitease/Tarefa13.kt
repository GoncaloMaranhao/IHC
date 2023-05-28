package com.example.babbysitease

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
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
import com.example.babbysitease.databinding.ActivityTarefa12Binding
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.babbysitease.databinding.ActivityTarefa13Binding
import com.google.android.material.textfield.TextInputEditText
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.roundToInt

class Tarefa13 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa13Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val clientTextView: TextView = findViewById(R.id.clientTextView)
        val clientTextView2: TextView = findViewById(R.id.clientTextView2)
        val clientTextView3: TextView = findViewById(R.id.clientTextView3)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            clientTextView.text = Html.fromHtml("<b><u>Child</u></b>", Html.FROM_HTML_MODE_LEGACY)
            clientTextView2.text = Html.fromHtml("<b><u>Caregiver</u></b>", Html.FROM_HTML_MODE_LEGACY)
            clientTextView3.text = Html.fromHtml("<b><u>Location</u></b>", Html.FROM_HTML_MODE_LEGACY)
        } else {
            clientTextView.text = Html.fromHtml("<b><u>Child</u></b>")
            clientTextView2.text = Html.fromHtml("<b><u>Caregiver</u></b>")
            clientTextView3.text = Html.fromHtml("<b><u>Location</u></b>")
        }


        val navView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa13)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
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

        val now = Calendar.getInstance()


        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        val startTimeEditText: TextInputEditText = findViewById(R.id.startTimeEditText)
        val endTimeEditText: TextInputEditText = findViewById(R.id.endTimeEditText)

        val startTimeListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val selectedTime = Calendar.getInstance()
            selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            selectedTime.set(Calendar.MINUTE, minute)
            startTimeEditText.setText(timeFormat.format(selectedTime.time))
        }

        val endTimeListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val selectedTime = Calendar.getInstance()
            selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            selectedTime.set(Calendar.MINUTE, minute)
            endTimeEditText.setText(timeFormat.format(selectedTime.time))
        }

        startTimeEditText.setOnClickListener {
            val now = Calendar.getInstance()
            TimePickerDialog(this, R.style.themeOnverlay_timePicker, startTimeListener, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true).show()
        }

        endTimeEditText.setOnClickListener {
            val now = Calendar.getInstance()
            TimePickerDialog(this, R.style.themeOnverlay_timePicker, endTimeListener, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true).show()
        }

        val hours = now.get(Calendar.HOUR_OF_DAY)
        val minutes = now.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this,
            R.style.themeOnverlay_timePicker,
            startTimeListener,
            hours,minutes,true)


        binding.setAppointmentButton.setOnClickListener {
            val intent = Intent(this, Tarefa14::class.java)
            startActivity(intent)
        }

        supportActionBar?.apply {
            title = "Set Appointment"
            setDisplayHomeAsUpEnabled(true)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, Tarefa12::class.java)
        startActivity(intent)
        finish()
        return true
    }
}
