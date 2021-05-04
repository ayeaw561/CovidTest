package com.example.covidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class CovidInfoActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_info)
        //val backButton = findViewById<Button>(R.id.backbutton)
        val locations = findViewById<TextView>(R.id.locList_tv)



        val tv = findViewById<TextView>(R.id.zipcode_tv)
        val zip = intent.getStringExtra("Zipcode").toString()

        val textv = tv.text.toString()


        readDataFirestore(zip, textv)

    }

    private fun readDataFirestore(zip : String, textv : String) {


        db.collection("Locations").document(zip)
                .get()
                .addOnSuccessListener { document ->
                    try {
                        val address = document.data?.get("address").toString()
                        val city = document.data?.get("city").toString()
                        val name = document.data?.get("name").toString()
                        val vaccination = document.data?.get("vaccination").toString()
                        if (document != null) {
                            Log.d(textv, "DocumentSnapshot read successfully!")

                            val vAddress = findViewById<TextView>(R.id.cAddress)
                            val vCity = findViewById<TextView>(R.id.cCity)
                            val vName = findViewById<TextView>(R.id.cName)
                            val vVaccination = findViewById<TextView>(R.id.cVaccination)

                            vAddress.text = address
                            vCity.text = city
                            vName.text = name
                            vVaccination.text = vaccination

                            //address.text
                            //city.text = document.getString(field: city)

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