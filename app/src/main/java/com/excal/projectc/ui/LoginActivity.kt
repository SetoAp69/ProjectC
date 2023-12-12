package com.excal.projectc.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.excal.projectc.R
import com.excal.projectc.data.roomdatabase.UserDatabase
import com.excal.projectc.databinding.ActivityLoginBinding
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var database: UserDatabase
    private  val viewModel :LoginViewModel by inject()
    private lateinit var binding: ActivityLoginBinding


//    private suspend fun isEmailValid(email:String, password:String):UserEntity?{
//        return withContext(Dispatchers.IO){
//            val validEmail = database.userDao().getUser(email,password)
//            validEmail
//
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        database = UserDatabase.getInstance(applicationContext)

        emailEditText = findViewById(R.id.tv_email)
        passwordEditText = findViewById(R.id.tv_password)

        val buttonClick = findViewById<Button>(R.id.button)

        init()
        observeData()

        Log.i("Android Lifecycle Login ","On Create")

    }

    private fun init(){
        with(binding){
            button.setOnClickListener{
                if(tvEmail.text.isNullOrBlank()){
                    tvEmail.error="Mohon isi Email dengan benar"
                }
                if(tvPassword.text.isNullOrBlank()){
                    tvPassword.error="Mohon masukan Password dengan benar"
                }
                if(!tvEmail.text.isNullOrBlank()&& !tvPassword.text.isNullOrBlank()){
                    viewModel.getDataLogin(tvEmail.text.toString(), tvPassword.text.toString())
                }
            }
            button2.setOnClickListener{
                val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
                startActivity(intent)
            }
        }

    }
    private fun observeData(){
        with(viewModel){
            observeIsLogin().observe(this@LoginActivity) {
                it.let { data ->
                    if (data != null) {
                        val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Email sudah terdaftar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        }

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