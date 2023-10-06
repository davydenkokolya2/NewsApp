package com.example.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.domain.CategoryCardModel
import com.example.newsapp.domain.InterestingCardModel
import com.example.newsapp.ui.NavigationViewModel
import com.example.newsapp.ui.news_details.NewsDetailsViewModel
import com.example.newsapp.util.Constant
import com.example.newsapp.util.Navigation
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val newsDetailsViewModel: NewsDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.layoutManager = layoutManager
        binding.rvCategories.adapter = CategoryViewAdapter(Constant.categories, ::onClick)

        val layoutManager2 = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTrending.layoutManager = layoutManager2

        val layoutManager3 = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvInteresting.layoutManager = layoutManager3

        lifecycleScope.launch {
            homeViewModel.stateCategoryCardModel.collect {
                binding.rvInteresting.adapter = InterestingViewAdapter(Constant.interestingList[it], ::onClickInteresting)
                binding.rvTrending.adapter = TrendingViewAdapter(Constant.trendingList[it], ::onClickTrending)
            }
        }
        return binding.root
    }
    private fun onClick(position: Int, list: List<CategoryCardModel>) {
        homeViewModel.loadState(position)
    }
    private fun onClickInteresting(position: Int, list: List<InterestingCardModel>) {
        newsDetailsViewModel.loadState(list[position])
        navigationViewModel.loadState(Navigation.NEWS_DETAILS)
    }

    private fun onClickTrending(position: Int, list: List<InterestingCardModel>) {
        newsDetailsViewModel.loadState(list[position])
        navigationViewModel.loadState(Navigation.NEWS_DETAILS)
    }
}