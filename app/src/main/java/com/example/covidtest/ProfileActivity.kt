package com.example.covidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile1)
        val testVal = findViewById<TextView>(R.id.testVal_tv)
        testVal.text = intent.getStringExtra("Test")
        val email = findViewById<TextView>(R.id.email_tv)
        email.text = intent.getStringExtra("Email")
        val first = findViewById<TextView>(R.id.first_tv)
        first.text = intent.getStringExtra("First")
        val last = findViewById<TextView>(R.id.last_tv)
        last.text = intent.getStringExtra("Last")
        val zip = findViewById<TextView>(R.id.zip_tv)
        zip.text = intent.getStringExtra("Zipcode")

    }
}