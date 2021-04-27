package com.example.covidtest

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

//import kotlin.android.synthetic.main.activity_firestore.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()
        val showButton = findViewById<Button>(R.id.btnLogin)
        val usrName = findViewById<EditText>(R.id.et_username)
        val usrPass = findViewById<EditText>(R.id.et_password)
        val tv = findViewById<TextView>(R.id.textView)

        showButton.setOnClickListener {

            // Getting the user input
            val text = usrName.text.toString()
            val pass = usrPass.text.toString()
            val textv = tv.text.toString()

            // Showing the user input
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, pass, Toast.LENGTH_SHORT).show()
            val users = db.collection("Users")
                .whereEqualTo("password", pass)
                .get()
            Log.d(textv, users.toString())
        }

    }


}