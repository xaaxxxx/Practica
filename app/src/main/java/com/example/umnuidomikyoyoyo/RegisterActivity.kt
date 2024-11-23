package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterActivity  : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        usernameEditText = findViewById(R.id.edit2page1)
        emailEditText = findViewById(R.id.edit2page2)
        passwordEditText = findViewById(R.id.edit2page3)
        loginButton = findViewById(R.id.buttonvoiti2)
        registerButton = findViewById(R.id.buttonregister2)

        registerButton.setOnClickListener {
            val usernameview = usernameEditText.text.toString()
            var emailview = emailEditText.text.toString()
            var passwordview = passwordEditText.text.toString()

            // Проверка полей на пустоту
            if (emailview.isEmpty() || passwordview.isEmpty() || usernameview.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()

            }

            // Проверка почты на корректность
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailview).matches()) {
                Toast.makeText(this, "Некорректный адрес электронной почты", Toast.LENGTH_SHORT)
                    .show()

            } else if (passwordview.length < 8) {
                Toast.makeText(this, "Пароль должен быть не менее 8 символов", Toast.LENGTH_SHORT)
                    .show()

            } else {

                Toast.makeText(this, "Проверка прошла успешно", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PincodeActivity::class.java)
                startActivity(intent)

                val job = Job()
                val scope = CoroutineScope(Dispatchers.Main + job)
                if (job.isActive) {
                    lifecycleScope.launch {
                        var supabase = scauth.getSB()
                        val user = supabase.auth.signUpWith(Email) {
                            email = emailEditText?.text.toString()
                            password = passwordEditText?.text.toString()
                        }
                    }
                }

                if (!job.isActive) {
                    job.cancel()
                }


            }

            loginButton.setOnClickListener {
                // Создание Intent для запуска нового Activity
                val intent = Intent(this, MainActivity::class.java)

                // Запуск нового Activity
                startActivity(intent)

            }
        }
    }
}