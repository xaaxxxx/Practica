package com.example.umnuidomikyoyoyo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RoomAddAdapter(private var data: Array<String>, private val typeData: IntArray) :
    RecyclerView.Adapter<RoomAddAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    private var itemClickListener: ItemClickListener? = null

    fun setOnItemClickListener(listener: ItemClickListener) {
        itemClickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameroom2)
        val imageView: ImageView = itemView.findViewById(R.id.pictureroom22)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemroomtwo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val roomName = data[position]
        val roomType = typeData[position]

        holder.nameTextView.text = roomName

        val drawable: Int = when (roomType) {
            1 -> R.drawable.shower // Замените на ваши drawable-ресурсы
            2 -> R.drawable.shower
            3 -> R.drawable.sofa
            4 -> R.drawable.sofa
            5 -> R.drawable.television
            6 -> R.drawable.television
            else -> {
                Log.e("ERROR", "Room image type is missing!")
                R.drawable.ic_launcher_foreground //  Или другое изображение по умолчанию
            }
        }
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, drawable))


        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(it, position)
        }
    }

    override fun getItemCount(): Int = data.size

    fun filterList(filteredList: Array<String>) {
        data = filteredList
        notifyDataSetChanged()
    }
}