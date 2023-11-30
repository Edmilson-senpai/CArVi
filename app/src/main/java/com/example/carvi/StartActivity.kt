package com.example.carvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

lateinit var btn_profile: Button
    lateinit var btn_notify: Button
    lateinit var btn_F1: Button
    lateinit var btn_F2: Button
    lateinit var btn_F3: Button
    lateinit var btn_F4: Button
    lateinit var btn_F5: Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        Log.i("StarActivity", "OnCreate")

        btn_profile = findViewById(R.id.btn_profile)
        btn_notify = findViewById(R.id.btn_notify)
        btn_F1 = findViewById(R.id.btn_F1)
        btn_F2 = findViewById(R.id.btn_F2)
        btn_F3 = findViewById(R.id.btn_F3)
        btn_F4 = findViewById(R.id.btn_F4)
        btn_F5 = findViewById(R.id.btn_F5)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val homeFragment = HomeFragment()
        val calendarFragment = CalendarFragment()
        val coursesFragment = CoursesFragment()
        val activitiesFragment = ActivitiesFragment()
        val moreFragment = MoreFragment()

        fragmentTransaction.add(R.id.container_Fragment, homeFragment)
        fragmentTransaction.commit()
        
        btn_profile = findViewById(R.id.btn_profile)
        btn_notify = findViewById(R.id.btn_notify)
        
        btn_profile.setOnClickListener {
            Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btn_notify.setOnClickListener {
            Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, NotifyActivity::class.java)
            startActivity(intent)
        }

        btn_F1.setOnClickListener {
            Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_Fragment, homeFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btn_F2.setOnClickListener {
            Toast.makeText(this, "Horario", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_Fragment, calendarFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btn_F3.setOnClickListener {
            Toast.makeText(this, "Cursos", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_Fragment, coursesFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btn_F4.setOnClickListener {
            Toast.makeText(this, "Actividades", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_Fragment, activitiesFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btn_F5.setOnClickListener {
            Toast.makeText(this, "Actividades", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_Fragment, moreFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("StarActivity", "onStart")
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