package com.example.covidtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
//import kotlin.android.synthetic.main.activity_firestore.*

class MainActivity : AppCompatActivity() {
    private lateinit var database: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun sendData() {
        database.collection("Users")
    }

}