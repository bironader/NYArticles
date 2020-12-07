package com.example.nyarticles.framework.presentaion

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.transition.TransitionInflater
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.databinding.FragmentArtcileListBinding
import com.example.nyarticles.databinding.FragmentArticalDetailsBinding
import com.example.nyarticles.framework.utils.GlideUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticalDetailsFragment : Fragment() {

    private var _binding: FragmentArticalDetailsBinding? = null
    private val binding: FragmentArticalDetailsBinding get() = _binding!!

    lateinit var article: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        article = ArticalDetailsFragmentArgs.fromBundle(requireArguments()).article
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_artical_details, container, false)

        binding.article = article
        GlideUtils.loadImageUrl(
            binding.articleImage,
            article.media[0].mediaMetadata.find { it.format == "mediumThreeByTwo440" }?.url
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
   
    }

}