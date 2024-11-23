package com.example.umnuidomikyoyoyo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity :AppCompatActivity() {


    var emailEditText = findViewById<EditText>(R.id.edit1page1)
    var passwordEditText = findViewById<EditText>(R.id.edit1page2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginButton = findViewById<Button>(R.id.buttonvoiti)
        val registerButton = findViewById<Button>(R.id.buttonregister1)
        var email = emailEditText.text.toString().trim()
        var password = passwordEditText.text.toString().trim()

        loginButton.setOnClickListener {

            if (isValidEmail(email) && isValidPassword(password)) {

                val job = Job()
                val scope = CoroutineScope(Dispatchers.Main + job)

                if (job.isActive)
                {
                    lifecycleScope.launch {
                        var supabase = scauth.getSB()
                        val user = supabase.auth.signInWith(Email) {
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