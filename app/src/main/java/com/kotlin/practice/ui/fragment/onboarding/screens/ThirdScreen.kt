package com.kotlin.practice.ui.fragment.onboarding.screens

import androidx.fragment.app.viewModels
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentThirdScreenBinding
import com.kotlin.practice.viewmodel.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreen : BaseFragment<FragmentThirdScreenBinding, OnBoardingViewModel>() {

    override val mViewModel: OnBoardingViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_third_screen

    override fun initViews() {
        mBinding.viewmodel = mViewModel
    }
}