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


        val datasetRooms = arrayOf("Гостиная", "Кухня", "Ванная")
        val datasetRoomsType = arrayOf(1, 2, 3)
        val roomAdapter = RoomAdapter(datasetRooms, datasetRoomsType)

        val recyclerViewRooms: RecyclerView = findViewById(R.id.recyclerViewRoomAdd)
        recyclerViewRooms.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewRooms.adapter = roomAdapter



        leftbutton3.setOnClickListener {
            // Переход на страницу регистрации
            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)
        }
    }
}