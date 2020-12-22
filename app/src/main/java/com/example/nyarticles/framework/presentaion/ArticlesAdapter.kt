package com.example.nyarticles.framework.presentaion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.databinding.ArticleItemBinding
import com.example.nyarticles.framework.presentaion.ArticlesAdapter.ArticleHolder
import com.example.nyarticles.framework.utils.GlideUtils
import com.example.nyarticles.framework.utils.ItemClickListener
import javax.inject.Inject

class ArticlesAdapter @Inject constructor() : RecyclerView.Adapter<ArticleHolder>() {

    private var items = listOf<Article>()

    lateinit var itemClickListener: ItemClickListener<Article>
    fun showItems(items: List<Article>) {
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


    inner class ArticleHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Article) {
            binding.item = item
            GlideUtils.loadImageUrl(
                binding.articleImg,
                if (item.media.isNotEmpty()) item.media[0].mediaMetadata.find { it.format == "mediumThreeByTwo210" }?.url else ""
            )
            binding.root.setOnClickListener {
                itemClickListener.itemClick(
                    item
                )
            }
        }
    }


}