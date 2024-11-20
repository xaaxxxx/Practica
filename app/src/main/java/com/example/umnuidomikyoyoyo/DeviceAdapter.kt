package com.example.umnuidomikyoyoyo

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView

class DeviceAdapter (private val devices: Array<DeviceData>, private val context: Context) :
    RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(view: View?, id: Int)
    }

    private var itemClickListener: ItemClickListener? = null

    fun setOnItemClickListener(listener: ItemClickListener) {
        itemClickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameofdevice)
        val descriptionTextView: TextView = itemView.findViewById(R.id.opisaniedevice)
        val imageView: ImageView = itemView.findViewById(R.id.picturedevice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemdevice, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val device = devices[position]
        holder.nameTextView.text = device.name
        holder.descriptionTextView.text = device.description
        holder.imageView.setImageResource(device.imageResId)

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(it, device.id)
        }
    }

    override fun getItemCount(): Int = devices.size
}