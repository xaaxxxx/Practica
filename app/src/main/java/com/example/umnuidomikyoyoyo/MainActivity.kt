package com.example.umnuidomikyoyoyo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.edit1page1)
        val passwordEditText = findViewById<EditText>(R.id.edit1page2)
        val loginButton = findViewById<Button>(R.id.buttonvoiti)
        val registerButton = findViewById<Button>(R.id.buttonregister1)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (isValidEmail(email) && isValidPassword(password)) {

                Toast.makeText(this, "Валидация успешна!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Pincodejoin::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Неверный email или пароль", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Валидация пароля. Например, минимальная длина 6 символов
        return password.length >= 6
    }
}