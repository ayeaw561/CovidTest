package com.example.covidtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showButton = findViewById<Button>(R.id.btnLogin)
        val usrName = findViewById<EditText>(R.id.et_username)
        val usrPass = findViewById<EditText>(R.id.et_password)
        val tv = findViewById<TextView>(R.id.textView)

        showButton.setOnClickListener {

            // Getting the user input

            val user = usrName.text.toString()
            val pass = usrPass.text.toString()
            val textv = tv.text.toString()

            readDataFromFirestore(user, textv, pass)

        }

    }

    private fun readDataFromFirestore(user : String, textv : String, pass : String) {


        db.collection("Users").document(user)
            .get()
            .addOnSuccessListener { document ->
                try {
                    val testval = document.data?.get("test result")
                    val password = document.data?.get("password")
                    val email = document.data?.get("email")
                    val zip = document.data?.get("zipcode")
                    val first = document.data?.get("first")
                    val last = document.data?.get("last")
                    if (document != null && password == pass) {
                        Log.d(textv, "DocumentSnapshot read successfully!")
                            val intent = Intent(this, ProfileActivity::class.java).apply {
                                putExtra("Test", testval.toString())
                                putExtra("Email", email.toString())
                                putExtra("Zipcode", zip.toString())
                                putExtra("First", first.toString())
                                putExtra("Last", last.toString())
                            }
                            startActivity(intent)
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

