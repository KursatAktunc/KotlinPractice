package com.kotlin.practice.viewmodel

import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.repository.OnBoardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SplashFragmentViewModel @Inject constructor(private val repository: OnBoardingRepository) :
    BaseViewModel() {

        //TODO buradan devam edilecek
}