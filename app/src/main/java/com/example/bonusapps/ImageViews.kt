package com.example.bonusapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.appcompat.content.res.AppCompatResources

class ImageViews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_views)

        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        setTitle("Image View")
        val image= findViewById<ImageView>(R.id.imageView)

        val toggle: ToggleButton = findViewById(R.id.toggleButton)

        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
            image.setImageResource(R.drawable.one)
            } else {
            image.setImageResource(R.drawable.tow)
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}