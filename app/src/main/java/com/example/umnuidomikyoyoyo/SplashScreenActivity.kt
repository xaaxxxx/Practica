package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_SCREEN_DISPLAY_LENGTH: Long = 2000 // Длительность отображения Splash Screen в миллисекундах

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java) // Замените MainActivity на целевой класс
            startActivity(intent)
            finish() // Закрываем Splash Screen Activity
        }, SPLASH_SCREEN_DISPLAY_LENGTH)
    }
}
