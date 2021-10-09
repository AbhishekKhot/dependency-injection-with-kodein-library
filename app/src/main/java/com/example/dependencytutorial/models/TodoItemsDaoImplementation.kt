package com.example.dependencytutorial.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dependencytutorial.data.TodoItems
import com.example.dependencytutorial.db.TodoItemsDao

class TodoItemsDaoImplementation : TodoItemsDao {
    private val ItemsList = mutableListOf<TodoItems>()
    private val TodoItemsLive = MutableLiveData<List<TodoItems>>()

    init {
        TodoItemsLive.value = ItemsList
    }

    override fun addItemsTodos(todoItems: TodoItems) {
       ItemsList.add(todoItems)
        TodoItemsLive.value = ItemsList
    }

    override fun getItemsTodos() = TodoItemsLive as LiveData<List<TodoItems>>
}