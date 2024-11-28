package com.example.userinterfaceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Liste d'exemples de livres
        val bookList = listOf(
            Book("Le Petit Prince", "Antoine de Saint-Exupéry"),
            Book("1984", "George Orwell"),
            Book("Harry Potter", "J.K. Rowling")
        )

        // Configuration du RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BookAdapter(bookList)
    }
}
