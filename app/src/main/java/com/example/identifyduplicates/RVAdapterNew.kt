package com.example.identifyduplicates

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView


class RVAdapterNew(
    val listFruits: ArrayList<String>
) : RecyclerView.Adapter<RVAdapterNew.NewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item,
            parent,
            false
        )
        NewViewHolder.viewHolder()
        return NewViewHolder(itemView, textWatcher())
    }

    class NewViewHolder(itemView: View, textWatcher: TextWatcher) : RecyclerView.ViewHolder(itemView) {
        val etInput = itemView.findViewById<EditText>(R.id.etInput)

        fun viewHolder(v: View, textWatcher: TextWatcher) {
            etInput.addTextChangedListener(textWatcher)
        }
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }

    class textWatcher: TextWatcher {

        fun updatePosition(position: Int) {
            this.position = position
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            listFruits[position] = p0.toString().trim()
        }

    }
}