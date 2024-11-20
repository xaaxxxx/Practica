package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.hardware.input.HostUsiVersion
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.chrono.HijrahChronology

class RoomAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roomadd)
        val leftbutton3 = findViewById<ImageView>(R.id.leftbutton3)


        val datasetRoomsAdd = arrayOf("Гостиная", "Кухня", "Ванная")
        val datasetRoomsAddType = arrayOf(1, 2, 3)
        val roomAddAdapter = RoomAddAdapter(datasetRoomsAdd, datasetRoomsAddType)

        val recyclerViewRoomsAdd: RecyclerView = findViewById(R.id.recyclerViewRoomAdd)
        recyclerViewRoomsAdd.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewRoomsAdd.adapter = roomAddAdapter



        leftbutton3.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }
    }
}