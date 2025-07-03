package com.bignerdranch.android.syubaevae_02_05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail : EditText = findViewById(R.id.etEmail)
        val etPassword : EditText = findViewById(R.id.etPassword)
        val blogin : Button = findViewById(R.id.bLogin)
        val bRegister : Button = findViewById(R.id.bRegister)

        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()

        val sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        val savedEmail = sharedPreferences.getString("email", email)
        val savedPassword = sharedPreferences.getString("password", password)

        blogin.setOnClickListener {
            val intent = Intent(this@login, second_screen::class.java)

            if (email.isNullOrEmpty() || password.isNullOrEmpty()){
                Snackbar.make(findViewById(android.R.id.content), "Введите логин или пароль", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 8){
                Snackbar.make(findViewById(android.R.id.content), "Пароль меньше 8 символов", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (savedEmail == null || savedPassword == null){
                with(sharedPreferences.edit()){
                    putString("email", email)
                    putString("password", password)
                    apply()
                }
                if (savedEmail == email && savedPassword == password){
                    startActivity(intent)
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "Неверный логин или пароль", Snackbar.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            bRegister.setOnClickListener {
                deleteSharedPreferences("user")
                Snackbar.make(findViewById(android.R.id.content), "Введите новый логин и пароль", Snackbar.LENGTH_SHORT).show()

            }

        }
    }
}