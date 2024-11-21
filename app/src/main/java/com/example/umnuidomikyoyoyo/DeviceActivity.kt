package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DeviceActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ustroistva, container, false)
        val addButton = view.findViewById<ImageButton>(R.id.addbutton)
        val recyclerViewDevices: RecyclerView = view.findViewById(R.id.recyclerViewDevices)
        recyclerViewDevices.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val devices = arrayOf(
            DeviceData(1, "Лента", "Скорость", R.drawable.laptop), // Используйте ваши drawable
            DeviceData(2, "Микроволновка", "Мощность", R.drawable.fridge),
            DeviceData(3, "Мультиварка", "Температура", R.drawable.sofa)
        )

        val adapter = DeviceAdapter(devices, requireContext())
        recyclerViewDevices.adapter = adapter

        adapter.setOnItemClickListener(object : DeviceAdapter.ItemClickListener {
            override fun onItemClick(view: View?, id: Int) {
                val intent = Intent(requireContext(), DeviceDetailActivity::class.java)
                intent.putExtra("deviceId", id)
                startActivity(intent)
            }
        })

        addButton.setOnClickListener {
            val intent = Intent(requireContext(), DeviceAddActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}