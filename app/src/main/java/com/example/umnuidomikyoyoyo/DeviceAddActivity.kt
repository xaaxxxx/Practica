package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class DeviceAddActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adddevice)

        val leftbutton1 = findViewById<ImageButton>(R.id.leftbutton1)



        leftbutton1.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, DeviceActivity::class.java)
            startActivity(intent)
        }
    }
}