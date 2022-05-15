package com.kotlin.practice.viewmodel

import androidx.lifecycle.viewModelScope
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.repository.OnBoardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashFragmentViewModel @Inject constructor(private val repository: OnBoardingRepository) :
    BaseViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _startDestination =
        MutableStateFlow(R.id.action_splashFragment_to_onBoardingMainFragment)
    val startDestination: StateFlow<Int> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed)
                    _startDestination.value = R.id.action_splashFragment_to_mainFragment
                else
                    _startDestination.value = R.id.action_splashFragment_to_onBoardingMainFragment
            }
            _isLoading.value = false
        }
    }
}