package com.example.nyarticles.framework.presentaion

import android.content.Context
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nyarticles.R

class ListCustomView(context: Context) : FrameLayout(context) {

    lateinit var adapter: ArticlesAdapter


    init {
        inflate(context, R.layout.custom_recycler, this)

        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        val articlesList = findViewById<RecyclerView>(R.id.list)
        adapter = ArticlesAdapter()
        articlesList.layoutManager = GridLayoutManager(context, 2)
        articlesList.adapter = adapter

    }


    fun notifyChanges(list: List<Article>) = adapter.showItems(list)


}