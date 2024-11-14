package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.hardware.input.HostUsiVersion
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.time.chrono.HijrahChronology

class RoomAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roomadd)
        val leftbutton3 = findViewById<ImageButton>(R.id.leftbutton3)



        leftbutton3.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)
        }
    }
}