package com.example.nyarticles.framework.presentaion.articledetails

import android.os.Bundle
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.databinding.FragmentArticalDetailsBinding
import com.example.nyarticles.framework.presentaion.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticalDetailsFragment : BaseFragment<FragmentArticalDetailsBinding>() {


    private lateinit var article: ArticleDomainModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        article = ArticalDetailsFragmentArgs.fromBundle(requireArguments()).article

    }


    override fun bindViews() {
        binding.article = article
    }

    override fun getLayoutResId() = R.layout.fragment_artical_details

}