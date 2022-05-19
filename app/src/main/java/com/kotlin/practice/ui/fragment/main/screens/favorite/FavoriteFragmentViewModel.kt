package com.kotlin.practice.ui.fragment.main.screens.favorite

import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteFragmentViewModel @Inject constructor(private val repository: FavoriteRepository) :
    BaseViewModel() {

}