package com.example.babbysitease

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa14Binding
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan
import java.util.Calendar

class Tarefa14 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa14Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa14Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa14)
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

        supportActionBar?.apply {
            title = "Appointments made"
            setDisplayHomeAsUpEnabled(true)
        }

        val currentMonthCalendarView: MaterialCalendarView = findViewById(R.id.currentMonthCalendarView)

        val currentDate = Calendar.getInstance()
        val previousDate = Calendar.getInstance()
        previousDate.add(Calendar.MONTH, -1)

        setupCalendar(currentMonthCalendarView, currentDate)

        val highlightDays = setOf(4, 5, 6, 12, 13, 14, 15, 22, 23, 17, 25, 26, 28, 31)

        val selectedDaysDecorator = object : DayViewDecorator {
            override fun shouldDecorate(day: CalendarDay): Boolean {
                return day.day in highlightDays
            }

            override fun decorate(view: DayViewFacade) {
                view.addSpan(DotSpan(5f, Color.RED))
            }

        }

        currentMonthCalendarView.addDecorator(selectedDaysDecorator)
        currentMonthCalendarView.addDecorator(object : DayViewDecorator {

            private val colorSpan = ForegroundColorSpan(Color.WHITE)

            override fun shouldDecorate(day: CalendarDay): Boolean {
                return true
            }

            override fun decorate(view: DayViewFacade) {
                view.addSpan(colorSpan)
            }
        })

        //currentMonthCalendarView.setHeaderTextAppearance(R.style.CalendarWidgetHeader);
        //currentMonthCalendarView.setOnDateChangedListener { widget, date, selected ->
        //    val intent = Intent(this, Tarefa11_1::class.java)
        //    startActivity(intent)
        //}
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, Tarefa13::class.java)
        startActivity(intent)
        finish()
        return true
    }
    private fun setupCalendar(calendarView: MaterialCalendarView, date: Calendar) {
        val firstDayOfMonth = Calendar.getInstance()
        firstDayOfMonth.time = date.time
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1)
        val lastDayOfMonth = Calendar.getInstance()
        lastDayOfMonth.time = date.time
        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH))
        calendarView.state().edit()
            .setMinimumDate(firstDayOfMonth)
            .setMaximumDate(lastDayOfMonth)
            .commit()
    }


}


