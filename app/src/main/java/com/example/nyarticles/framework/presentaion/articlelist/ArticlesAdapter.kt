package com.example.nyarticles.framework.presentaion.articlelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.databinding.ArticleItemBinding
import com.example.nyarticles.framework.presentaion.articlelist.ArticlesAdapter.ArticleHolder
import com.example.nyarticles.framework.utils.ItemClickListener
import javax.inject.Inject

class ArticlesAdapter @Inject constructor() :
    RecyclerView.Adapter<ArticleHolder>() {

    private var items = listOf<ArticleDomainModel>()
    lateinit var itemClickListener: ItemClickListener<ArticleDomainModel>

    fun showItems(items: List<ArticleDomainModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val binding = DataBindingUtil.inflate<ArticleItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.article_item, parent, false
        )
        return ArticleHolder(binding)
    }


    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    inner class ArticleHolder(
        private val binding: ArticleItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: ArticleDomainModel) {
            binding.item = item
            binding.root.setOnClickListener {
                if (::itemClickListener.isInitialized)
                    itemClickListener.itemClick(item)

            }
        }


    }
}