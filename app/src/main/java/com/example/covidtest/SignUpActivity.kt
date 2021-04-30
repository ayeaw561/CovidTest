package com.example.covidtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class SignUpActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)
        val signupButton = findViewById<Button>(R.id.btn_signup)
        val usrEmail = findViewById<EditText>(R.id.et_email)
        val usrPass = findViewById<EditText>(R.id.et_password)
        val usrName = findViewById<EditText>(R.id.et_username)
        val usrFirst = findViewById<EditText>(R.id.et_first)
        val usrLast = findViewById<EditText>(R.id.et_last)
        val usrZip = findViewById<EditText>(R.id.et_zip)
        val tv = findViewById<TextView>(R.id.textView)

        signupButton.setOnClickListener {

        val email = usrEmail.text.toString()
            val userN = usrName.text.toString()
        val first = usrFirst.text.toString()
        val last = usrLast.text.toString()
        val password = usrPass.text.toString()
        val zip = usrZip.text.toString()
            val textv = tv.text.toString()

            dataToFirestore(email, first, last, password, zip, userN, textv)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

private fun dataToFirestore(email : String, first : String, last : String, password : String, zip : String, userN : String, textv : String) {

    val doc = hashMapOf(
        "email" to email,
        "first" to first,
        "last" to last,
        "password" to password,
        "test result" to "negative",
        "zipcode" to zip
    )

    db.collection("Users").document(userN)
        .set(doc)
        .addOnSuccessListener { Log.d(textv, "DocumentSnapshot successfully written!") }
        .addOnFailureListener { e -> Log.w(textv, "Error writing document", e) }


}
}