package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RoomAddActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextSearch: EditText
    private lateinit var adapter: RoomAddAdapter
    private val roomData = listOf(
        Pair("Гостиная", 1),
        Pair("Кухня", 2),
        Pair("Ванная", 3),
        Pair("Спальня", 4),
        Pair("Прихожая", 5)
    )
    private lateinit var leftbutton3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roomadd)

        leftbutton3 = findViewById(R.id.leftbutton3)
        recyclerView = findViewById(R.id.recyclerViewRoomAdd)
        editTextSearch = findViewById(R.id.poisk)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val rooms = roomData.map { it.first }.toTypedArray()
        val roomTypes = roomData.map { it.second }.toIntArray()
        adapter = RoomAddAdapter(rooms, roomTypes)
        recyclerView.adapter = adapter


        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }
        })

        leftbutton3.setOnClickListener {
            val intent = Intent(this,  MainPage::class.java) // Замените на вашу активность
            startActivity(intent)
        }

        adapter.setOnItemClickListener(object : RoomAddAdapter.ItemClickListener {
            override fun onItemClick(view: View?, position: Int) {
                // Обработка клика на элемент RecyclerView
            }
        })
    }

    private fun filter(text: String) {
        val filteredList = if (text.isEmpty()) {
            roomData.map { it.first }.toTypedArray()
        } else {
            roomData.filter { it.first.lowercase().contains(text.lowercase()) }
                .map { it.first }
                .toTypedArray()
        }
        adapter.filterList(filteredList)
    }
}