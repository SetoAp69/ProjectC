package com.excal.projectc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.excal.projectc.ui.LoginActivity
import com.excal.projectc.ui.MenuActivity
import com.excal.projectc.ui.RegistrationActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, RegistrationActivity::class.java))
            finish()
        },3000)
    }

}