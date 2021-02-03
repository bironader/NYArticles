package com.example.nyarticles.framework.presentaion.articlelist

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.framework.utils.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleListCustomView(context: Context, attributes: AttributeSet) :
    RecyclerView(context, attributes) {


    @Inject
    lateinit var articlesAdapter: ArticlesAdapter


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        populateRecyclerView()
    }

    fun showItems(list: List<ArticleDomainModel>) = articlesAdapter.showItems(list)


    private fun populateRecyclerView() {
        this.adapter = articlesAdapter
    }

    fun setOnItemClick(itemClickListener: ItemClickListener<ArticleDomainModel>) {
        articlesAdapter.itemClickListener = itemClickListener
    }


    fun clean() {
        this.adapter = null
    }

}