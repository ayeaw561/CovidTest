package com.example.covidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }


    }
}