package com.example.dependencytutorial.db

import com.example.dependencytutorial.models.TodoItemsDaoImplementation

class DatabaseTemporalImplementation : Database {
    override val todoDao: TodoItemsDao = TodoItemsDaoImplementation()
}
