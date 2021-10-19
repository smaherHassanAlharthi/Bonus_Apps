package com.example.bonusapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources

class PersistentCalculation : AppCompatActivity() {

    var calcResult= 0.0
    lateinit var result:TextView

    companion object {
        const val RESULT_KEY = "RESULT_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistent_calculation)

        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        setTitle("Persistent Calculation")

        val doubleNum= findViewById<EditText>(R.id.etDouble)
        val floatNum= findViewById<EditText>(R.id.etFloat)
        val calculate= findViewById<Button>(R.id.btCalc)
         result= findViewById<TextView>(R.id.tvResult)

        calculate.setOnClickListener{
            if(doubleNum.text.isNotEmpty() && floatNum.text.isNotEmpty()){
                result.text= (calculate(doubleNum.text.toString().toDouble(),floatNum.text.toString().toFloat())).toString()
                calcResult= result.text.toString().toDouble()
            }
            else
                Toast.makeText(this,"Please enter two numbers to calculate!",Toast.LENGTH_SHORT).show()
        }


    }
    fun calculate(num1:Double,num2:Float): Double{
        return num1* num2
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble(RESULT_KEY, calcResult)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var calcResult = savedInstanceState.getDouble(RESULT_KEY)
        //restore value for instance
        result.text= calcResult.toString()
    }

}