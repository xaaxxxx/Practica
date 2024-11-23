package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RoomAdapter(
    private val roomsList: ArrayList<DataRooms>, private val context: HouseActivity
) : RecyclerView.Adapter<RoomAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView = itemView.findViewById(R.id.room_text)
        var image: ImageView = itemView.findViewById(R.id.room_device_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.itemroom, parent, false)
        return MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rooms = roomsList[position]


        holder.name.text = rooms.room_name
        Log.e("!Adapter", rooms.room_name)



    }

    override fun getItemCount(): Int {
        return roomsList.size
    }

}