package com.example.nyarticles.framework.presentaion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.Resource
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.databinding.ActivityMainBinding
import com.example.nyarticles.databinding.ArtcileListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ArtcileListFragment : Fragment() {


    private val viewModel: ArtcileListViewModel by viewModels()
    private var _binding: ArtcileListFragmentBinding? = null
    private val binding: ArtcileListFragmentBinding get() = _binding!!

    @Inject
    lateinit var articlesAdapter: ArticlesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.artcile_list_fragment, container, false)
        populateRecyclerView()
        binding.swipeRef.setOnRefreshListener { refresh() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.stateLiveData.observe(viewLifecycleOwner, Observer {
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
                    Timber.d("failed${it.throwable.message}")
                    binding.swipeRef.isRefreshing = false
                    Toast.makeText(requireContext(), it.throwable.message, LENGTH_LONG).show()
                }
            }
        })
    }


    override fun onStart() {
        super.onStart()
        refresh()
    }

    private fun refresh() {
        viewModel.fetchArticles()
    }

    private fun populateRecyclerView() {
        binding.articlesList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.articlesList.adapter = articlesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}