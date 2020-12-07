package com.example.nyarticles.framework.presentaion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.blankj.utilcode.util.SnackbarUtils
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.databinding.FragmentArtcileListBinding
import com.example.nyarticles.framework.utils.ItemClickListener
import com.example.nyarticles.framework.utils.getMessage
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ArticleListFragment : Fragment() {


    private val viewModel: ArticleListViewModel by viewModels()
    private var _binding: FragmentArtcileListBinding? = null
    private val binding: FragmentArtcileListBinding get() = _binding!!

    @Inject
    lateinit var articlesAdapter: ArticlesAdapter


    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_artcile_list, container, false)


        populateRecyclerView()
        binding.swipeRef.setOnRefreshListener { refresh() }
        refresh()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.stateLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is Loading -> {
                    Timber.d("loading")
                    binding.swipeRef.isRefreshing = true
                }
                is Success -> {
                    Timber.d("success")
                    binding.swipeRef.isRefreshing = false
                    it.data.items?.let { items -> articlesAdapter.showItems(items) }
                }
                is Failure -> {
                    binding.swipeRef.isRefreshing = false
                    SnackbarUtils.with(binding.root)
                        .setMessage(it.errorTypes.getMessage(requireContext())).showError()
                }
            }
        })
    }


    private fun refresh() {
        viewModel.fetchArticles()
    }

    private fun populateRecyclerView() {
        binding.articlesList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.articlesList.adapter = articlesAdapter
        articlesAdapter.itemClickListener = object : ItemClickListener<Article> {
            override fun itemClick(item: Article) {
                val action =
                    ArticleListFragmentDirections.actionArtcileListFragmentToArticalDetailsFragment(
                        item, item.title
                    )
                findNavController().navigate(action)


            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}