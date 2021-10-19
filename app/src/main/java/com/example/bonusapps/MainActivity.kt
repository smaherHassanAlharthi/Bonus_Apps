package com.example.bonusapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        val btCounter= findViewById<Button>(R.id.btCounter)
        val btPres= findViewById<Button>(R.id.btPres)
        val btArray= findViewById<Button>(R.id.btArray)
        val btLife= findViewById<Button>(R.id.btLife)
        val btSC= findViewById<Button>(R.id.btSC)
        val btImage= findViewById<Button>(R.id.btImage)

        btCounter.setOnClickListener{
          startActivity(Intent(this,ButtonCounter::class.java))
        }
        btPres.setOnClickListener{
            startActivity(Intent(this,PersistentCalculation::class.java))
        }
        btArray.setOnClickListener{
            startActivity(Intent(this,ArrayListActivity::class.java))
        }
        btLife.setOnClickListener{
            startActivity(Intent(this,ActivityLifecycle::class.java))
        }
        btSC.setOnClickListener{
            startActivity(Intent(this,SimpleCalculator::class.java))
        }
        btImage.setOnClickListener{
            startActivity(Intent(this,ImageViews::class.java))
        }
    }
}