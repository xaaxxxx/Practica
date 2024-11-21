package com.example.umnuidomikyoyoyo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView

class FamilyAdapter (private val data: Array<String>, private val typeData:Array<Int>) : RecyclerView.Adapter<FamilyAdapter.ViewHolder>()  {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var TitleText: TextView?
        var Image: ImageView?

        init {
            TitleText = itemView?.findViewById<TextView>(R.id.nameuser)
            Image = itemView?.findViewById(R.id.pictureuser);
            itemView.setOnClickListener(this)
        }

        var mClickListener: ItemClickListener? = null
        public fun setOnClickListener(clickListener: ItemClickListener)
        {
            mClickListener = clickListener
        }
        override fun onClick(p0: View?) {
            mClickListener?.onItemClick(p0, adapterPosition)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemfamily, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val TitleText: String = data!![position]
        val Type: Int = typeData!![position]

        holder.TitleText?.setText(TitleText)

        when (Type) {
            1 -> holder.Image?.setImageResource(R.drawable.cowboy)
            2 -> holder.Image?.setImageResource(R.drawable.cowboy)
            3 -> holder.Image?.setImageResource(R.drawable.cowboy)
            4 -> holder.Image?.setImageResource(R.drawable.cowboy)
            5 -> holder.Image?.setImageResource(R.drawable.cowboy)
            6 -> holder.Image?.setImageResource(R.drawable.cowboy)
            else -> {
                Log.e("ERROR", "Room image type is missing!")
            }
        }
    }
    override fun getItemCount(): Int {
        return data!!.size
    }

    fun getItem(id: Int): String? {
        return data!![id]
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}