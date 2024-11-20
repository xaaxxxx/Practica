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

class FamilyActivity : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.familytree, container, false)

        val addbutton2 = view.findViewById<ImageButton>(R.id.addbutton)





        val datasetUsers = arrayOf("Браток", "Батек", "Дедок")
        val datasetUserType = arrayOf(1, 2, 3)
        val roomAdapter = FamilyAdapter(datasetUsers, datasetUserType)

        val recyclerViewRooms: RecyclerView = view.findViewById(R.id.recyclerViewFamily)
        recyclerViewRooms.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewRooms.adapter = roomAdapter




        addbutton2.setOnClickListener {

            val intent = Intent(requireContext(), ProfileAddActivity::class.java)
            startActivity(intent)
        }

       return view
    }
}