package com.example.identifyduplicates

import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var listFruits: ArrayList<String>
    lateinit var rvListFruits: RecyclerView
    lateinit var btnAdd: Button
    lateinit var rvAdapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListFruits = findViewById(R.id.rvList)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            addFruit()
        }

        initializeListFruits()
        initializeRV()
    }

    private fun initializeListFruits() {
        listFruits = arrayListOf(
            "apple",
            "banana",
            "orange"
        )
    }

    private fun initializeRV() {
        rvAdapter = RVAdapter(listFruits)
        rvListFruits.adapter = rvAdapter
    }

    private fun addFruit() {
        updateList()

        val fruit = "Fruit"
        listFruits.add(fruit)

        rvAdapter.notifyDataSetChanged()
    }

    private fun updateList() {
        val updatedListFruits = arrayListOf<String>()

        val itemCount = rvListFruits.adapter!!.itemCount
        for (i in 0 until itemCount) { // add all subjectColor to newListSubjectColor
            val holder = rvListFruits.findViewHolderForAdapterPosition(i)
            if (holder != null) {
                val editText = holder.itemView.findViewById<EditText>(R.id.etInput)
                val fruit = editText.text.toString().trim()
                updatedListFruits.add(fruit)
            }
        }

        listFruits.clear()
        listFruits.addAll(updatedListFruits)
    }
}