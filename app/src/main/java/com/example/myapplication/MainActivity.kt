package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<String>
    private val todoList = ArrayList<String>()
    private lateinit var listView: ListView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        listView = findViewById(R.id.listView)
        editText = findViewById(R.id.editText)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
        listView.adapter = adapter

        fab.setOnClickListener {
            addTodo()
        }
    }

    private fun addTodo() {
        val todo = editText.text.toString()
        if (todo.isNotEmpty()) {
            todoList.add(todo)
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }
    }
}