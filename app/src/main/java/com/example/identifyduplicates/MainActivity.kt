package com.example.identifyduplicates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var listFruits: ArrayList<String>
    lateinit var rvListFruits: RecyclerView
    lateinit var btnAdd: Button
    lateinit var rvAdapter: RVAdapterNew

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
        rvAdapter = RVAdapterNew(listFruits)
        rvListFruits.adapter = rvAdapter
    }

    private fun addFruit() {
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

        val newFruit = ""
        updatedListFruits.add(newFruit)

        listFruits.clear()
        listFruits.addAll(updatedListFruits)

        rvAdapter.notifyDataSetChanged()
    }

    fun updateList() {
        val updatedListFruits = arrayListOf<String>()

        val itemCount = rvListFruits.adapter!!.itemCount
        for (i in 0 until itemCount) { // add all fruits to updatedListFruits
            val holder = rvListFruits.findViewHolderForAdapterPosition(i)
            if (holder != null) { // TODO: adapter always returns null here
                val editText = holder.itemView.findViewById<EditText>(R.id.etInput)
                val fruit = editText.text.toString().trim()
                updatedListFruits.add(fruit)
            }
        }

        listFruits.clear()
        listFruits.addAll(updatedListFruits)
    }

    fun updateFruit(fruit: String, position: Int) {
        listFruits[position] = fruit // changes from old fruit to new fruit
    }
}