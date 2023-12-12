package com.excal.projectc.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.excal.projectc.R
import com.excal.projectc.data.roomdatabase.UserDatabase
import com.excal.projectc.data.roomdatabase.UserEntity
import com.excal.projectc.databinding.ActivityRegistrationBinding
import org.koin.android.ext.android.inject

class RegistrationActivity : AppCompatActivity() {
    private lateinit var database: UserDatabase
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText1: EditText
    private lateinit var passwordEditText2: EditText
    private lateinit var createAccountButton: Button
//    private lateinit var txtLogin: TextView
    private lateinit var binding: ActivityRegistrationBinding
    private  val viewModel:RegisterViewModel by inject()


//    private suspend fun isEmailUsed(email:String):Boolean {
//       return withContext(Dispatchers.IO){
//           val usedEmail = database.userDao().getUser(email)
//            usedEmail !=null
//       }
//
//    }

    override fun onCreate(savedInstanceState: Bundle?)  {

        super.onCreate(savedInstanceState)

        binding =ActivityRegistrationBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val txtLogin =  findViewById<TextView>(R.id.txtLogin)
        Log.i("Android Lifecycle Reg ","On Create")
        txtLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        init()
        observeData()


    }
    private fun observeData(){
        with(viewModel){
            observeIsRegister().observe(this@RegistrationActivity){
                it.let {data ->
                    if(data){
                        val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this@RegistrationActivity,"Email sudah terdaftar",Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }

    }


    private fun init(){
        usernameEditText = findViewById(R.id.usernameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText1 = findViewById(R.id.passwordEditText1)
        passwordEditText2 = findViewById(R.id.passwordEditText2)
        binding.createAccountButton.setOnClickListener{
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password1 = passwordEditText1.text.toString()
            val password2 = passwordEditText2.text.toString()
            val user = UserEntity(userName = username, email = email, password = password1)
            if (username.isEmpty() || email.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
                return@setOnClickListener
            }else{
                if (password1 != password2) {
                    Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else{

                }
            }
            viewModel.insertUser(user)

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