package com.example.bonusapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import java.text.SimpleDateFormat
import java.util.*

class ActivityLifecycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        setTitle("Activity Lifecycle")


    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.tvOnline).append("\nOnline")
    }

    override fun onPause() {
        findViewById<TextView>(R.id.tvOnline).append("\nLast Seen:${
            SimpleDateFormat("hh:mm:ss a dd/M/yyyy").format(
            Date()
        )}")
        super.onPause()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}