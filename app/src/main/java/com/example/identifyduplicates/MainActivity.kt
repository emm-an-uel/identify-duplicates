package com.example.identifyduplicates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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
        for (i in 0 until itemCount) { // add all fruit to updatedListFruits
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
        listFruits[position] = fruit // updates old fruit to new fruit

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

    fun checkDuplicates() { // checkDuplicates() is run in MainActivity so it can iterate through all items in rvList

        val itemCount = rvListFruits.adapter!!.itemCount

        for (i in 0 until itemCount) {
            val holder = rvListFruits.findViewHolderForAdapterPosition(i)
            if (holder != null) {
                val etInput = holder.itemView.findViewById<EditText>(R.id.etInput)
                val fruit = etInput.text.toString().trim()

                val count = listFruits.count { it == fruit }

                if (count > 1) {
                    etInput.setTextColor(ContextCompat.getColor(this, R.color.red))
                } else {
                    etInput.setTextColor(ContextCompat.getColor(this, R.color.white))
                }
            }
        }
    }
}