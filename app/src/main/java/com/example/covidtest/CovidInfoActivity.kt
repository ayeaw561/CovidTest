package com.example.covidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class CovidInfoActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_info)
        //val backButton = findViewById<Button>(R.id.)
        val locations = findViewById<TextView>(R.id.locList_tv)
        val tv = findViewById<TextView>(R.id.textView20)
        val zip = intent.getStringExtra("Zipcode").toString()

        val textv = tv.text.toString()


        readDataFirestore(zip, textv)

    }

    private fun readDataFirestore(zip : String, textv : String) {


        db.collection("Locations").document(zip)
                .get()
                .addOnSuccessListener { document ->
                    try {
                        val address = document.data?.get("address")
                        val city = document.data?.get("city")
                        val name = document.data?.get("name")
                        val vaccination = document.data?.get("vaccination")
                        if (document != null) {
                            Log.d(textv, "DocumentSnapshot read successfully!")



                            

                        } else {
                            Log.d(textv, "No such document!")
                        }
                    } catch (ex: Exception){
                        Log.e(textv, ex.message.toString())
                    }
                }.addOnFailureListener { e ->
                    Log.e(textv, "Error writing document", e)
                }
    }
}