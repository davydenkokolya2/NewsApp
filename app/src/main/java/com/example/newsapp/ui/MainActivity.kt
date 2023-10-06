package com.example.newsapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.R
import com.example.newsapp.ui.home.HomeFragment
import com.example.newsapp.ui.news_details.NewsDetailsFragment
import com.example.newsapp.ui.onboarding.OnboardingFragment
import com.example.newsapp.util.Navigation
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val navigationViewModel: NavigationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            navigationViewModel.stateNavigation.collect {
                when(it) {
                    Navigation.HOME -> replaceFragment(HomeFragment())
                    Navigation.ONBOARDING -> replaceFragment(OnboardingFragment())
                    Navigation.NEWS_DETAILS -> replaceFragment(NewsDetailsFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}