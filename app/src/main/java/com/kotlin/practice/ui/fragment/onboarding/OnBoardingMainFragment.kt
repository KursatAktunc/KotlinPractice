package com.kotlin.practice.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
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

        binding.viewPager2.adapter = adapter

        binding.wormDotsIndicator.attachTo(binding.viewPager2)

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0)
                    binding.button3.visibility = View.INVISIBLE
                else
                    binding.button3.visibility = View.VISIBLE

                if (position == 2)
                    binding.button2.visibility = View.INVISIBLE
                else
                    binding.button2.visibility = View.VISIBLE
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })

        binding.button2.setOnClickListener {
            binding.viewPager2.setCurrentItem(binding.viewPager2.currentItem + 1, true)
        }

        binding.button3.setOnClickListener {
            binding.viewPager2.setCurrentItem(binding.viewPager2.currentItem - 1, true)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}