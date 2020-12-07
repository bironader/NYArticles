package com.example.nyarticles.framework.features.articles_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.nyarticles.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtcileListFragment : Fragment() {


    private val viewModel: ArtcileListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.artcile_list_fragment, container, false)
    }


}