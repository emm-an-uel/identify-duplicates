package com.example.identifyduplicates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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

        showListFruits()
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

    fun updateFruit(fruit: String, position: Int) {
        listFruits[position] = fruit // changes from old fruit to new fruit

        showListFruits()
    }

    private fun showListFruits() {
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        linearLayout.removeAllViews()

        for (fruit in listFruits) {
            val textView = TextView(this)
            textView.text = fruit
            linearLayout.addView(textView)
        }
    }
}