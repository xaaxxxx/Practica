package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ProfileAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val leftbutton2 = findViewById<ImageView>(R.id.leftbutton2)



        leftbutton2.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, FamilyActivity::class.java)
            startActivity(intent)
        }
    }
}