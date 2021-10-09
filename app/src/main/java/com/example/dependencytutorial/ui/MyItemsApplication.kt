package com.example.dependencytutorial.ui

import android.app.Application
import com.example.dependencytutorial.db.TodoItemsDao
import com.example.dependencytutorial.repository.TodoItemsRepository
import com.example.dependencytutorial.models.TodoItemsRepositoryImplementation
import com.example.dependencytutorial.models.TodoItemsViewModelFactory
import com.example.dependencytutorial.db.Database
import com.example.dependencytutorial.db.DatabaseTemporalImplementation
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyItemsApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseTemporalImplementation() }
        bind<TodoItemsDao>() with singleton { instance<Database>().todoDao }
        bind<TodoItemsRepository>() with singleton { TodoItemsRepositoryImplementation(instance()) }
        bind() from provider { TodoItemsViewModelFactory(instance()) }

    }
}