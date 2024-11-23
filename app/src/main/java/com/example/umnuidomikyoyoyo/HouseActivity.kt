package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class HouseActivity : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.house, container, false)

        val imageView: ImageButton= view.findViewById(R.id.addbutton)

        val datasetRooms = arrayOf("Гостиная", "Кухня", "Ванная")
        val datasetRoomsType = arrayOf(1, 2, 3)
        val roomAdapter = RoomAdapter(datasetRooms, datasetRoomsType)

        val recyclerViewRooms: RecyclerView = view.findViewById(R.id.recyclerViewRoomsInHouse)
        recyclerViewRooms.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewRooms.adapter = roomAdapter

        val addbutton = view.findViewById<ImageButton>(R.id.addbutton)


        addbutton.setOnClickListener {
            // Переход к AddActivity
            val intent = Intent(requireContext(), RoomAddActivity::class.java)
            startActivity(intent)
        }


        return view

    }
}
