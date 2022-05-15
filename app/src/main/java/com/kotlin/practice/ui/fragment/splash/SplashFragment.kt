package com.kotlin.practice.ui.fragment.splash

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentSplashBinding
import com.kotlin.practice.viewmodel.SplashFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashFragmentViewModel>() {

    override val mViewModel: SplashFragmentViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_splash

    override fun initViews() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        mBinding.imageView.animation = AnimationUtils.loadAnimation(context, R.anim.splash_anim)

        !mViewModel.isLoading.value
        Log.d("SplashFragment", mViewModel.isLoading.value.toString())
        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launchWhenResumed {
                Log.d("SplashFragment", mViewModel.startDestination.value.toString())
                findNavController().navigate(mViewModel.startDestination.value)
            }
        }, 2000)
    }
}