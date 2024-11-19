package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DeviceAddActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adddevice)

        val leftbutton1 = findViewById<ImageView>(R.id.leftbutton1)

        val datasetRooms = arrayOf("Лента", "Микроволновка", "Мультиварка")
        val datasetRoomsType = arrayOf(1, 2, 3)
        val roomAdapter = RoomAdapter(datasetRooms, datasetRoomsType)

        val recyclerViewRooms: RecyclerView = findViewById(R.id.recyclerViewDeviceAdd)
        recyclerViewRooms.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewRooms.adapter = roomAdapter



        leftbutton1.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, DeviceActivity::class.java)
            startActivity(intent)
        }
    }
}