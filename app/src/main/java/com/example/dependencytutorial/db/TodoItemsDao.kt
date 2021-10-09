package com.example.dependencytutorial.db

import androidx.lifecycle.LiveData
import com.example.dependencytutorial.data.TodoItems

interface TodoItemsDao {
    fun addItemsTodos(quote: TodoItems)
    fun getItemsTodos():LiveData<List<TodoItems>>
}