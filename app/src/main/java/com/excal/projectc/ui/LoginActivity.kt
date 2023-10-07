package com.excal.projectc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.excal.projectc.R
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.util.Log

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonClick = findViewById<Button>(R.id.button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        val registeClick = findViewById<TextView>(R.id.button2)
        registeClick.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)


        }
        Log.i("Android Lifecycle Login ","On Create")

    }
    override fun onStart() {
        super.onStart()
        Log.i("Android Lifecycle Login ","On Start")

    }
    override fun onPause() {
        super.onPause()
        Log.i("Android Lifecycle Login ","On pause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Android Lifecycle Login ","On Destroy")

    }

    override fun onStop() {
        super.onStop()
        Log.i("Android Lifecycle Login ","On Stop")

    }
}