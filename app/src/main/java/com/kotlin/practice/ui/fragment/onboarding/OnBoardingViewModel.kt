package com.kotlin.practice.ui.fragment.onboarding

import androidx.lifecycle.viewModelScope
import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.repository.OnBoardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val repository: OnBoardingRepository) :
    BaseViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }

    fun finisOnBoardingClick() {
        saveOnBoardingState(completed = true)
        navigate(OnBoardingMainFragmentDirections.actionOnBoardingMainFragmentToMainFragment())
    }

}