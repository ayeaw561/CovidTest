package com.example.covidtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

//import kotlin.android.synthetic.main.activity_firestore.*

class MainActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val db = FirebaseFirestore.getInstance()
        val showButton = findViewById<Button>(R.id.btnLogin)
        val usrName = findViewById<EditText>(R.id.et_username)
        val usrPass = findViewById<EditText>(R.id.et_password)
        val tv = findViewById<TextView>(R.id.textView)

        showButton.setOnClickListener {

            // Getting the user input
            val testval = " "

            val text = usrName.text.toString()
            val pass = usrPass.text.toString()
            val textv = tv.text.toString()

            readDataFromFirestore(text, textv, pass)

        }

    }

    private fun readDataFromFirestore(text : String, textv : String, pass : String){


        db.collection("Users").document(text)
                .get()
                .addOnSuccessListener { document ->
                    try {
                        if (document != null) {
                            Log.d(textv, "DocumentSnapshot read successfully!")
                            val testval = document.data?.get("testval")
                            val password = document.data?.get("password")
                            val intent = Intent(this, )
                        } else {
                            Log.d(textv, "No such document!")
                        }
                    }catch (ex: Exception){
                        Log.e(textv, ex.message.toString())
                    }
                }.addOnFailureListener {
                    e -> Log.e(textv, "Error writing document", e)
                }
    }


}