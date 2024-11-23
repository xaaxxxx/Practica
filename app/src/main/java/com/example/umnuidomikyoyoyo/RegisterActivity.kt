package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register) // Замените на ваш файл разметки
        val usernameEditText = findViewById<EditText>(R.id.edit2page1)
        val emailEditText = findViewById<EditText>(R.id.edit2page2)
        val passwordEditText = findViewById<EditText>(R.id.edit2page3)
        val registerButton = findViewById<Button>(R.id.buttonregister2)
        val loginButton = findViewById<Button>(R.id.buttonvoiti2)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            var email = emailEditText.text.toString().trim()
            var password = passwordEditText.text.toString().trim()

            if (isValidUsername(username) && isValidEmail(email) && isValidPassword(password)) {




                val job = Job()
                val scope = CoroutineScope(Dispatchers.Main + job)

                if (job.isActive)
                {
                    lifecycleScope.launch {
                        var supabase = scauth.getSB()
                        val user = supabase.auth.signUpWith(Email) {
                            email = emailEditText?.text.toString()
                            password = passwordEditText?.text.toString()
                        }

                        /*
                        sc.getSB().auth.signUpWith(Email) {
                            email = "test@example.com"
                            password = "123456"
                        }*/

                    } //.isCompleted
                }

                if (!job.isActive)
                    job.cancel()





                // Валидация пройдена, выполните регистрацию
                Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PincodeActivity::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show()
            }
        }

        loginButton.setOnClickListener {
            // Переход на главную страницу
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidUsername(username: String): Boolean {
        // Валидация имени пользователя. Например, минимальная длина 3 символа
        return username.length >= 3
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Валидация пароля. Например, минимальная длина 6 символов
        return password.length >= 6
    }
}