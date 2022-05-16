package com.kotlin.practice.viewmodel

import androidx.lifecycle.viewModelScope
import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.base.Resource
import com.kotlin.practice.base.ResourceError
import com.kotlin.practice.base.ResourceStatus
import com.kotlin.practice.models.Products
import com.kotlin.practice.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsFragmentViewModel @Inject constructor(private val repository: ProductsRepository) :
    BaseViewModel() {

    private val _resource =
        MutableStateFlow<Resource<List<Products>>>(Resource(ResourceStatus.PROGRESS))
    val resource: StateFlow<Resource<List<Products>>> = _resource

    //val resource = MutableLiveData<Resource<List<Products>>>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _resource.value = Resource(
            ResourceStatus.ERROR,
            null,
            throwable.localizedMessage?.let { ResourceError(62, it) })
    }

    fun getAllProducts() {
        _resource.value = Resource(ResourceStatus.PROGRESS)

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getAllProducts()

            if (response.isSuccessful)
                _resource.value = Resource(ResourceStatus.SUCCESS, response.body())
            else
                _resource.value =
                    Resource(ResourceStatus.ERROR, null, ResourceError(61, response.message()))

        }
    }
}