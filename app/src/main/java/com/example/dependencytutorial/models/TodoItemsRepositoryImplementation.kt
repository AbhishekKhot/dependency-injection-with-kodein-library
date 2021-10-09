package com.example.dependencytutorial.models

import com.example.dependencytutorial.data.TodoItems
import com.example.dependencytutorial.db.TodoItemsDao
import com.example.dependencytutorial.repository.TodoItemsRepository

class TodoItemsRepositoryImplementation(private val todoItemsDao: TodoItemsDao) :
    TodoItemsRepository {
    override fun addItemsTodos(todoItems: TodoItems) {
        todoItemsDao.addItemsTodos(todoItems)
    }

    override fun getItemsTodos() = todoItemsDao.getItemsTodos()
}