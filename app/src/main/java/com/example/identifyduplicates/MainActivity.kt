package com.example.identifyduplicates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var listFruits: ArrayList<String>
    lateinit var rvListFruits: RecyclerView
    lateinit var tvDuplicate: TextView
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListFruits = findViewById(R.id.rvList)
        tvDuplicate = findViewById(R.id.tvDuplicate)
        editText = findViewById(R.id.editText)

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
        val adapter = RVAdapter(listFruits)
        rvListFruits.adapter = adapter
    }
}