package com.example.dependencytutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dependencytutorial.R
import com.example.dependencytutorial.data.TodoItems
import com.example.dependencytutorial.models.TodoItemsViewModel
import com.example.dependencytutorial.models.TodoItemsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class TodoActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: TodoItemsViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settingUpUi()
    }

    private fun settingUpUi() {
        val viewModel = ViewModelProviders.of(this,viewModelFactory).get(TodoItemsViewModel::class.java)

        viewModel.getItemTodo().observe(this, Observer { item ->
            val stringBuilder = StringBuilder()
            item.forEach{items ->
                stringBuilder.append("$items\n\n")
            }
            textViewItems.text = stringBuilder.toString()
        })

        buttonItemTodo.setOnClickListener {
            val todoItems = TodoItems(editTextItemsTodo.text.toString(),editTextItemsTodoDate.text.toString())
            viewModel.addItemTodo(todoItems)
            editTextItemsTodo.setText("")
            editTextItemsTodoDate.setText("")
        }
    }
}