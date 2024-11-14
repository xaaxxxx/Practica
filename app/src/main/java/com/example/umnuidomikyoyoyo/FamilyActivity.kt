package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FamilyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.familytree)
        val roomButton = findViewById<Button>(R.id.roomButton)
        val deviceButton = findViewById<Button>(R.id.deviceButton)
        val userButton = findViewById<Button>(R.id.userButton)
        val addbutton2 = findViewById<ImageButton>(R.id.addbutton)
        val famset = findViewById<ImageButton>(R.id.famset)

        roomButton.setOnClickListener {
            Toast.makeText(this, "Переход к комнатам", Toast.LENGTH_SHORT).show()
            // Здесь вы должны перейти к новой активности, которая отображает комнаты.
            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)
            // Используйте Intent для запуска новой активности.
        }

        deviceButton.setOnClickListener {
            Toast.makeText(this, "Переход к устройствам", Toast.LENGTH_SHORT).show()
            // Здесь вы должны перейти к новой активности, которая отображает устройства.
            val intent = Intent(this, DeviceActivity::class.java)
            startActivity(intent)
        }

        userButton.setOnClickListener {
            Toast.makeText(this, "Переход к пользователям", Toast.LENGTH_SHORT).show()
            // Здесь вы должны перейти к новой активности, которая отображает пользователей.
            val intent = Intent(this, FamilyActivity::class.java)
            startActivity(intent)
        }

        addbutton2.setOnClickListener {
            // Переход к AddActivity
            val intent = Intent(this, ProfileAddActivity::class.java)
            startActivity(intent)
        }

        famset.setOnClickListener {
            // Переход к AddActivity
            val intent = Intent(this, AdressActivity::class.java)
            startActivity(intent)
        }
    }
}