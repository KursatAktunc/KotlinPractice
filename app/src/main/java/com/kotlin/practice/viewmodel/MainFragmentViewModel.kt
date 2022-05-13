package com.kotlin.practice.viewmodel

import androidx.lifecycle.ViewModel
import com.kotlin.practice.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel  @Inject constructor() : BaseViewModel() {

}