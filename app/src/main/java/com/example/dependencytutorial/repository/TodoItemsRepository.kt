package com.example.dependencytutorial.repository

import androidx.lifecycle.LiveData
import com.example.dependencytutorial.data.TodoItems

interface TodoItemsRepository  {

    fun addItemsTodos(todoItems: TodoItems)
    fun getItemsTodos():LiveData<List<TodoItems>>
}