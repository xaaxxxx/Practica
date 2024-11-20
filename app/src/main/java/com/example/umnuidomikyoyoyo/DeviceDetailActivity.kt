package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeviceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_detail)

        val leftbutton3 = findViewById<ImageView>(R.id.leftbuttonitem)
        val deviceId = intent.getIntExtra("deviceId", -1)
        val deviceNameTextView: TextView = findViewById(R.id.deviceName)
        val deviceOpisTextView: TextView = findViewById(R.id.deviceOpis)
        val deviceImageView: ImageView = findViewById(R.id.deviceImage)

        val device = when (deviceId) {
            1 -> DeviceData(1, "Лента", "Скорость", R.drawable.fridge)
            2 -> DeviceData(2, "Микроволновка", "Мощность", R.drawable.television)
            3 -> DeviceData(3, "Мультиварка", "Температура", R.drawable.shower)
            else -> null
        }

        device?.let {
            deviceNameTextView.text = it.name
            deviceOpisTextView.text = it.description
            deviceImageView.setImageResource(it.imageResId)
        } ?: run {
            deviceNameTextView.text = "Ошибка"
            deviceOpisTextView.text = "Устройство не найдено"
        }

        leftbutton3.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }
    }
}
