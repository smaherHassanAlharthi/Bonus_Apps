package com.example.bonusapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources





class SimpleCalculator : AppCompatActivity() {
    lateinit var num1:EditText
    lateinit var num2:EditText
    lateinit var result:TextView
    lateinit var add:Button
    lateinit var sub:Button
    lateinit var mul:Button
    lateinit var div:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_calculator)

        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        setTitle("Simple Calculator")

        num1= findViewById(R.id.etNum1)
        num2= findViewById(R.id.etNum2)
        result= findViewById(R.id.tvResults)

        add= findViewById<Button>(R.id.btAddition)
        sub= findViewById<Button>(R.id.btSubtraction)
        mul= findViewById<Button>(R.id.btMul)
        div= findViewById<Button>(R.id.btDiv)

        add.setOnClickListener{if(num1.text.isNotEmpty()&&num2.text.isNotEmpty()) calculate(add)}
        sub.setOnClickListener{if(num1.text.isNotEmpty()&&num2.text.isNotEmpty()) calculate(sub)}
        mul.setOnClickListener{if(num1.text.isNotEmpty()&&num2.text.isNotEmpty()) calculate(mul)}
        div.setOnClickListener{if(num1.text.isNotEmpty()&&num2.text.isNotEmpty()) calculate(div)}
    }
     fun calculate(v:View) {
        var r=0f
         try {
             when (v) {

                 add -> {
                     r = num1.text.toString().toFloat() + num2.text.toString().toFloat()
                     result.text = r.toString()
                 }
                 sub -> {
                     r = num1.text.toString().toInt() - num2.text.toString().toFloat()
                     result.text = r.toString()
                 }
                 mul -> {
                     r = num1.text.toString().toFloat() * num2.text.toString().toFloat()
                     result.text = r.toString()
                 }
                 div -> {
                     r = num1.text.toString().toFloat() / num2.text.toString().toFloat()
                     result.text = r.toString()
                 }
             }
         }catch (e:Exception){
             Toast.makeText(this,"Something Wrong!", Toast.LENGTH_SHORT).show()
         }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}