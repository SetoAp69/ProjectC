package com.excal.projectc.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.excal.projectc.R

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.excal.projectc.data.roomdatabase.UserDatabase
import com.excal.projectc.data.roomdatabase.UserEntity
import com.excal.projectc.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.withContext

class RegistrationActivity : AppCompatActivity() {
    private lateinit var database: UserDatabase
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText1: EditText
    private lateinit var passwordEditText2: EditText
    private lateinit var createAccountButton: Button
//    private lateinit var txtLogin: TextView
    private lateinit var binding: ActivityRegistrationBinding

    private suspend fun isEmailUsed(email:String):Boolean{
       return withContext(Dispatchers.IO){
           val usedEmail = database.userDao().getEmail(email)
            usedEmail !=null
       }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityRegistrationBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_registration)

        val txtLogin =  findViewById<TextView>(R.id.txtLogin)
        Log.i("Android Lifecycle Reg ","On Create")
        txtLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        database = UserDatabase.getInstance(applicationContext)

        usernameEditText = findViewById(R.id.usernameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText1 = findViewById(R.id.passwordEditText1)
        passwordEditText2 = findViewById(R.id.passwordEditText2)
        //createAccountButton = findViewById(R.id.createAccountButton)

        val createAccButton = findViewById<Button>(R.id.createAccountButton)
        createAccButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password1 = passwordEditText1.text.toString()
            val password2 = passwordEditText2.text.toString()

            if (username.isEmpty() || email.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
                return@setOnClickListener
            }

            if (password1 != password2) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            GlobalScope.launch (Dispatchers.IO){
                val emailAlreadyUsed = isEmailUsed(email)
                if(emailAlreadyUsed){
                    withContext(Dispatchers.Main){
                        Log.i("Email is used", "Email is being used")
                        Toast.makeText(this@RegistrationActivity,"Email already used", Toast.LENGTH_SHORT).show()

                    }
                }else{
                    val user = UserEntity(userName = username, email = email, password = password1)
                    database.userDao().registerUser(user)

                    withContext(Dispatchers.Main) {
                        val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
//                    val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
//                    startActivity(intent)
                }
            }







//            GlobalScope.launch(Dispatchers.IO){
//                if(database.userDao().getEmail(email)!=null){
//                    Toast.makeText(this@RegistrationActivity,"Email already used",Toast.LENGTH_SHORT).show()
//
//                }else{
//
//                }
//            }





        }
    }




    override fun onStart() {
        super.onStart()
        Log.i("Android Lifecycle Reg ","On Start")



    }
    override fun onPause() {
        super.onPause()
        Log.i("Android Lifecycle Reg ","On Pause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Android Lifecycle Reg ","On Destroy")

    }

    override fun onStop() {
        super.onStop()
        Log.i("Android Lifecycle Reg ","On Stop")

    }
}