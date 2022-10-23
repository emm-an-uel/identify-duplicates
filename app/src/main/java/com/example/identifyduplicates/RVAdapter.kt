package com.example.identifyduplicates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter (
    private val listFruits: ArrayList<String>
        ): RecyclerView.Adapter<RVAdapter.NewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item,
            parent,
            false
        )
        return NewViewHolder(itemView)
    }

    class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.textView.text = listFruits[position]
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }
}