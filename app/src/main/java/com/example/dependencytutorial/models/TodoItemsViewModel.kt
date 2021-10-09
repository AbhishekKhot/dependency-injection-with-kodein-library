package com.example.dependencytutorial.models

import androidx.lifecycle.ViewModel
import com.example.dependencytutorial.data.TodoItems
import com.example.dependencytutorial.repository.TodoItemsRepository

class TodoItemsViewModel(private val todoItemsRepository: TodoItemsRepository): ViewModel() {

    fun addItemTodo(todoItems: TodoItems) = todoItemsRepository.addItemsTodos(todoItems)

    fun getItemTodo() = todoItemsRepository.getItemsTodos()
}