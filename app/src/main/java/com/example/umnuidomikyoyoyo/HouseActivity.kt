package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.renderscript.Element.DataType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import java.lang.Exception

class HouseActivity : Fragment()  {


    var roomsList: ArrayList<DataRooms> = ArrayList<DataRooms>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.house, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewRoomsInHouse)
        val adapter = RoomAdapter(roomsList, this@HouseActivity)

        lifecycleScope.launch {

            try {
                val room_type = scauth.getSB().postgrest["Room_type"].select() {
                }.decodeList<DataTypeRooms>()

                Log.e("Type", room_type[0].name.toString() + "|" + room_type[0].id)

                val client = scauth.getSB().postgrest["Room"].select() {

                }.decodeList<DataRooms>()

                Log.e("1", client[0].id.toString() + "|" + client[0].room_name)

                for (c in client) {
                    Log.e("id: " + c.id, "|" + c.room_name + "|" + room_type[c.type_room_id])
                }



            } catch (e: Exception) {
                Log.e("2", e.toString())
            }
            recyclerView.adapter = adapter
        }






        val addbutton = view.findViewById<ImageButton>(R.id.addbutton)


        addbutton.setOnClickListener {
            // Переход к AddActivity
            val intent = Intent(requireContext(), RoomAddActivity::class.java)
            startActivity(intent)
        }


        return view

    }
}
