package com.kotlin.practice.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.base.Resource
import com.kotlin.practice.models.Products
import com.kotlin.practice.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class ProductsFragmentViewModel @Inject constructor(private val repository: ProductsRepository) :
    BaseViewModel() {

}