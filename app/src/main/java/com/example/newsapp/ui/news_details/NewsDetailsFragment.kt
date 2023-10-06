package com.example.newsapp.ui.news_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.databinding.FragmentNewsDetailsBinding
import com.example.newsapp.ui.NavigationViewModel
import com.example.newsapp.util.Navigation
import kotlinx.coroutines.launch

class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val newsDetailsViewModel: NewsDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        binding.btnBack.setOnClickListener {
            navigationViewModel.loadState(Navigation.HOME)
        }

        lifecycleScope.launch {
            newsDetailsViewModel.stateInterestingCardModel.collect {
                if (it != null) {
                    binding.tvCategory.setText(it.category)
                    binding.tvDescription.setText(it.description)
                    binding.tvTitle.setText(it.title)
                    binding.ivNewsDetailImage.setImageResource(it.full_image)
                }
            }
        }
        return binding.root
    }

}