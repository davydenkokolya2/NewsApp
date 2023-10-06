package com.example.newsapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.newsapp.databinding.FragmentOnboardingBinding
import com.example.newsapp.ui.NavigationViewModel
import com.example.newsapp.util.Navigation

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.btnStart.setOnClickListener {
            navigationViewModel.loadState(Navigation.HOME)
        }
        return binding.root
    }

}