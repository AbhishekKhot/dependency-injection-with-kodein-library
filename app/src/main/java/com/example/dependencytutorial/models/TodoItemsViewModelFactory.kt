package com.example.dependencytutorial.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencytutorial.repository.TodoItemsRepository

class TodoItemsViewModelFactory(private val todoItemsRepository: TodoItemsRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoItemsViewModel(todoItemsRepository) as T
    }
}