package com.example.nyarticles.framework.presentaion.articlelist

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.databinding.FragmentArtcileListBinding
import com.example.nyarticles.framework.presentaion.base.BaseFragment
import com.example.nyarticles.framework.utils.ItemClickListener
import com.example.nyarticles.framework.utils.getType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ArticleListFragment : BaseFragment<FragmentArtcileListBinding>(),
    ItemClickListener<ArticleDomainModel> {

    private val viewModel: ArticleListViewModel by viewModels()

    override fun bindViews() {
        binding.articlesList.setOnItemClick(this)
        binding.swipeRef.setOnRefreshListener { refresh() }
    }

    override fun getLayoutResId() = R.layout.fragment_artcile_list


    override fun observe() {
        super.observe()
        viewModel.stateLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is Loading -> {
                    binding.swipeRef.isRefreshing = true
                }
                is Success -> {
                    binding.articlesList.showItems(state.data)
                    binding.swipeRef.isRefreshing = false

                }
                is Failure -> {
                    handleErrors(state.throwable.getType())
                    binding.swipeRef.isRefreshing = false

                }
            }
        })
    }

    override fun onDestroyView() {
        binding.articlesList.clean()
        super.onDestroyView()
    }

    private fun refresh() {
        viewModel.fetchArticles()
    }

    override fun itemClick(item: ArticleDomainModel) {
        val action =
            ArticleListFragmentDirections.actionArtcileListFragmentToArticalDetailsFragment(
                item, item.title
            )
        findNavController().navigate(action)
    }


}