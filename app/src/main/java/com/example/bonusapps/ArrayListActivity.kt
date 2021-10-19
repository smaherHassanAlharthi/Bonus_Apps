package com.example.bonusapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import kotlin.collections.ArrayList

class ArrayListActivity : AppCompatActivity() {
    var namesArray=ArrayList<String>()
    lateinit var result:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_list)


        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        getSupportActionBar()!!.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.custom_button))
        setTitle("ArrayList Activity")

        val names= findViewById<EditText>(R.id.etNames)
        val number= findViewById<EditText>(R.id.etNumberToDisp)
        val add= findViewById<Button>(R.id.btAdd)
        val get= findViewById<Button>(R.id.btGet)
         result= findViewById(R.id.tvNames)

        add.setOnClickListener{
            if(names.text.isNotEmpty()){
                namesArray.add(names.text.toString())
                names.text.clear()
            }
            else
                Toast.makeText(this,"Please enter a name!", Toast.LENGTH_SHORT).show()
        }
        get.setOnClickListener{
            if(number.text.isNotEmpty()){
                display((number.text.toString().toInt()))
            }
            else
                Toast.makeText(this,"Please enter a number!",Toast.LENGTH_SHORT).show()
        }


    }

    private fun display(n: Int) {
        var namesList=""
       if(n<namesArray.size){
           for(i in 0..n-1)
           {
               namesList+=namesArray[i]+"\n"
           }
       }
        else//if number more than the names number print them all
       {
           for(i in namesArray)
           {
               namesList+=i+"\n"
           }
       }
        result.text=namesList
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}