package com.example.carvi

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

lateinit var login: Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()

        Log.i("MainActivity", "onCreate")

        login = findViewById<Button>(R.id.btn_login)

        /*login.setOnClickListener {
            Toast.makeText(this, "Inicio de sesion", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }*/

        val docRef = db.collection("Usuarios").document("Admin1")

        login.setOnClickListener {
            docRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        val data = documentSnapshot.data
                        Log.d(TAG, "Document data: $data")
                        println("Document data: $data")
                    } else {
                        Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting document", exception)
                }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart")
    }
}