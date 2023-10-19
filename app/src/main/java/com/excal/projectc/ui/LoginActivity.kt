package com.excal.projectc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.excal.projectc.R
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.excal.projectc.data.roomdatabase.UserDatabase
import com.excal.projectc.data.roomdatabase.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var database: UserDatabase

    private suspend fun isEmailValid(email:String):UserEntity?{
        return withContext(Dispatchers.IO){
            val validEmail = database.userDao().getEmail(email)
            validEmail

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.tv_email)
        passwordEditText = findViewById(R.id.tv_password)
        val buttonClick = findViewById<Button>(R.id.button)

        buttonClick.setOnClickListener {

            val email=emailEditText.text.toString()
            val password=passwordEditText.text.toString()
            database = UserDatabase.getInstance(applicationContext)


            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Password and/or Email can't be empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
            }else{
                GlobalScope.launch(Dispatchers.IO){
                    val emailValid = isEmailValid(email)
                    if(emailValid!=null){
                        Log.i("Login Activity","Email checked")
                        if(emailValid.password==password){
                            withContext(Dispatchers.Main){
                                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                                startActivity(intent)
                                finish()

                            }


                        }
                        else{
                            withContext(Dispatchers.Main){
                                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                                Toast.makeText(this@LoginActivity, "Email or Password are wrong", Toast.LENGTH_SHORT).show()


                            }

                        }
                    }else{
                        Toast.makeText(this@LoginActivity, "Email not found", Toast.LENGTH_SHORT).show()

                    }
                }
            }


        }

        val registerClick = findViewById<TextView>(R.id.button2)
        registerClick.setOnClickListener {


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