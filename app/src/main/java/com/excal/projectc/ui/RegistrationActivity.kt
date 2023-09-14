package com.excal.projectc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.excal.projectc.R

import com.excal.projectc.databinding.ActivityRegistrationBinding
import com.excal.projectc.databinding.ActivitySplashBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_registration)

        val registeClick = findViewById<TextView>(R.id.txtLogin)
        registeClick.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}