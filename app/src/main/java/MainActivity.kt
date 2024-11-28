package com.example.userinterfaceapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)
        val isNightMode = sharedPreferences.getBoolean("NightMode", false)
        AppCompatDelegate.setDefaultNightMode(
            if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )

        setContentView(R.layout.activity_main)

        val btnNextActivity: Button = findViewById(R.id.btnNextActivity)
        val btnToggleTheme: Button = findViewById(R.id.btnToggleTheme)

        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        btnToggleTheme.text = if (isNightMode) "Passer en mode jour" else "Passer en mode nuit"
        btnToggleTheme.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            val newMode = !isNightMode
            editor.putBoolean("NightMode", newMode)
            editor.apply()

            AppCompatDelegate.setDefaultNightMode(
                if (newMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
            recreate()
        }
    }
}
