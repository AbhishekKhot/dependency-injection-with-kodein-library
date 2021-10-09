package com.example.dependencytutorial.data

data class TodoItems(val taskText: String,
                     val taskDate: String)
{
    override fun toString(): String {
        return "$taskText - $taskDate"
    }
}