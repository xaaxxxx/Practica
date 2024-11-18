package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ustroistva)
        val roomButton = findViewById<Button>(R.id.roomButton)
        val deviceButton = findViewById<Button>(R.id.deviceButton)
        val userButton = findViewById<Button>(R.id.userButton)
        val addbutton = findViewById<ImageButton>(R.id.addbutton)
        val deviceset = findViewById<ImageButton>(R.id.deviceset)

        roomButton.setOnClickListener {
            Toast.makeText(this, "Переход к комнатам", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)

        }

        deviceButton.setOnClickListener {
            Toast.makeText(this, "Переход к устройствам", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DeviceActivity::class.java)
            startActivity(intent)
        }

        userButton.setOnClickListener {
            Toast.makeText(this, "Переход к пользователям", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, FamilyActivity::class.java)
            startActivity(intent)
        }

        addbutton.setOnClickListener {

            val intent = Intent(this, DeviceAddActivity::class.java)
            startActivity(intent)
        }

        deviceset.setOnClickListener {
            // Переход к AddActivity
            val intent = Intent(this, ProfileAddActivity::class.java)
            startActivity(intent)
        }
    }
}