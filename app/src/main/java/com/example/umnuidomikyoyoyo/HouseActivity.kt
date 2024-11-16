package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HouseActivity : AppCompatActivity() {

    private lateinit var textViewHouse: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.house)


        val roomset = findViewById<ImageButton>(R.id.roomset)
        val roomButton = findViewById<Button>(R.id.roomButton)
        val deviceButton = findViewById<Button>(R.id.deviceButton)
        val userButton = findViewById<Button>(R.id.userButton)
        val addbutton = findViewById<ImageButton>(R.id.addbutton)


        textViewHouse = findViewById(R.id.texthouse)

        val intent = intent
        if (intent != null) {
            val address = intent.getStringExtra("address")
            textViewHouse.text = address
        }

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
            // Переход к AddActivity
            val intent = Intent(this, RoomAddActivity::class.java)
            startActivity(intent)
        }

        roomset.setOnClickListener {
            // Переход к AddActivity
            val intent = Intent(this, AdressActivity::class.java)
            startActivity(intent)
        }
    }
}