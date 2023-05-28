package com.example.babbysitease

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.babbysitease.databinding.ActivityTarefa26Binding

class Tarefa26 : AppCompatActivity() {

    private lateinit var binding: ActivityTarefa26Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefa26Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_tarefa26)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
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
              AlertDialog.Builder(this)
                  .setTitle("Unsaved Changes")
                  .setMessage("You have unsaved information. Are you sure you wish to exit the page?")
                  .setPositiveButton(android.R.string.yes) { dialog, which ->
                      val intent = Intent(this, Tarefa32::class.java)
                      startActivity(intent)
                  }
                  .setNegativeButton(android.R.string.no, null)
                  .setIcon(android.R.drawable.ic_dialog_alert)
                  .show()
              true
          }
          R.id.navigation_dashboard -> {
              AlertDialog.Builder(this)
                  .setTitle("Unsaved Changes")
                  .setMessage("You have unsaved information. Are you sure you wish to exit the page?")
                  .setPositiveButton(android.R.string.yes) { dialog, which ->
                      val intent = Intent(this, Tarefa32::class.java)
                      startActivity(intent)
                  }
                  .setNegativeButton(android.R.string.no, null)
                  .setIcon(android.R.drawable.ic_dialog_alert)
                  .show()
              true
          }
          R.id.navigation_notifications -> {
              AlertDialog.Builder(this)
                  .setTitle("Unsaved Changes")
                  .setMessage("You have unsaved information. Are you sure you wish to exit the page?")
                  .setPositiveButton(android.R.string.yes) { dialog, which ->
                      val intent = Intent(this, Tarefa32::class.java)
                      startActivity(intent)
                  }
                  .setNegativeButton(android.R.string.no, null)
                  .setIcon(android.R.drawable.ic_dialog_alert)
                  .show()
              true
          }
          else -> false
        }
      }

      supportActionBar?.apply {
        title = "Save Changes"
        setDisplayHomeAsUpEnabled(true)
      }
        binding.saveChangesButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Confirm Save")
                .setMessage("Are you sure you want to save changes?")
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    val intent = Intent(this, Tarefa32::class.java)
                    startActivity(intent)
                }
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        AlertDialog.Builder(this)
            .setTitle("Unsaved Changes")
            .setMessage("You have unsaved information. Are you sure you wish to exit the page?")
            .setPositiveButton(android.R.string.yes) { dialog, which ->
                val intent = Intent(this, Tarefa25::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton(android.R.string.no, null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()

        return true
    }

}
