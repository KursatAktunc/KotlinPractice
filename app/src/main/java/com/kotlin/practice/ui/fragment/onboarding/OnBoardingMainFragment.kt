package com.kotlin.practice.ui.fragment.onboarding

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.kotlin.practice.R
import com.kotlin.practice.adapter.OnBoardingAdapter
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentOnboardingMainBinding
import com.kotlin.practice.ui.fragment.onboarding.screens.FirstScreen
import com.kotlin.practice.ui.fragment.onboarding.screens.SecondScreen
import com.kotlin.practice.ui.fragment.onboarding.screens.ThirdScreen
import com.kotlin.practice.util.extensions.hide
import com.kotlin.practice.util.extensions.show
import com.kotlin.practice.viewmodel.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingMainFragment : BaseFragment<FragmentOnboardingMainBinding, OnBoardingViewModel>() {

    override val mViewModel: OnBoardingViewModel by viewModels()

    private lateinit var adapter: OnBoardingAdapter

    override fun bindLayoutId(): Int = R.layout.fragment_onboarding_main

    override fun initViews() {
        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        adapter =
            OnBoardingAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        mBinding.viewPager2.adapter = adapter

        mBinding.wormDotsIndicator.attachTo(mBinding.viewPager2)

        mBinding.viewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0)
                    mBinding.btnPrev.hide()
                else
                    mBinding.btnPrev.show()

                if (position == 2) {
                    mBinding.btnNext.hide()
                } else {
                    mBinding.btnNext.show()
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })

        mBinding.btnNext.setOnClickListener {
            mBinding.viewPager2.setCurrentItem(mBinding.viewPager2.currentItem + 1, true)
        }

        mBinding.btnPrev.setOnClickListener {
            mBinding.viewPager2.setCurrentItem(mBinding.viewPager2.currentItem - 1, true)
        }
    }
}