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

        val datasetDeviceAdd = arrayOf("Лента", "Микроволновка", "Мультиварка")
        val datasetDeviceAddType = arrayOf(1, 2, 3)
        val deviceAddAdapter = DeviceAddAdapter(datasetDeviceAdd, datasetDeviceAddType)

        val recyclerViewRooms: RecyclerView = findViewById(R.id.recyclerViewDeviceAdd)
        recyclerViewRooms.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewRooms.adapter = deviceAddAdapter



        leftbutton1.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }
    }
}