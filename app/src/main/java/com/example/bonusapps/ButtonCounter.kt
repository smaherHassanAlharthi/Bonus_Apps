package com.example.bonusapps


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources

class ButtonCounter : AppCompatActivity() {
    var counter=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_counter)

        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        setTitle("Button Counter")

        val number= findViewById<TextView>(R.id.tvNum)
        counter=Integer.parseInt(number.text.toString())

        val plus= findViewById<Button>(R.id.plus)
        val minus= findViewById<Button>(R.id.minus)

        plus.setOnClickListener{
            counter++
            number.text= counter.toString()
        }
        minus.setOnClickListener{
            counter--
            number.text= counter.toString()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}