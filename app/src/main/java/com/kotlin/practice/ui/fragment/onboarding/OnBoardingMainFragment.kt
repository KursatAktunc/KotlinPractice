package com.kotlin.practice.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.practice.adapter.OnBoardingAdapter
import com.kotlin.practice.databinding.FragmentOnboardingMainBinding
import com.kotlin.practice.ui.fragment.onboarding.screens.FirstScreen
import com.kotlin.practice.ui.fragment.onboarding.screens.SecondScreen
import com.kotlin.practice.ui.fragment.onboarding.screens.ThirdScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingMainFragment : Fragment() {

    private var _binding: FragmentOnboardingMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: OnBoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingMainBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        adapter =
            OnBoardingAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        binding.wormDotsIndicator.attachTo(binding.viewPager)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}