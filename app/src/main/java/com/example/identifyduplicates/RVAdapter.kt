package com.example.identifyduplicates

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(
    private val listFruits: ArrayList<String>
) : RecyclerView.Adapter<RVAdapter.NewViewHolder>() {

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
        val etInput = itemView.findViewById<EditText>(R.id.etInput)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {

        val etInput = holder.etInput
        val fruit = listFruits[position]

        etInput.setText(fruit)
        etInput.addTextChangedListener(textWatcher(etInput, listFruits, position))

        checkIfExistsStart(fruit, etInput)
    }

    private fun checkIfExistsStart(input: String, etInput: EditText) {

        val context = etInput.context
        val count = listFruits.count { it == input }

        if (count > 1) {
            etInput.setTextColor(ContextCompat.getColor(context, R.color.red))
        } else {
            etInput.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }

    class textWatcher(
        val etInput: EditText,
        val listFruits: ArrayList<String>,
        val position: Int
    ) : TextWatcher {

        val context = etInput.context

        override fun afterTextChanged(p0: Editable?) {
            val input = p0.toString().trim()
            checkIfExists(input)

            (context as MainActivity).updateFruit(input, position)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        private fun checkIfExists(input: String) {

            val count = listFruits.count { it == input }

            if (count > 0) {
                etInput.setTextColor(ContextCompat.getColor(context, R.color.red))
            } else {
                etInput.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
        }
    }
}