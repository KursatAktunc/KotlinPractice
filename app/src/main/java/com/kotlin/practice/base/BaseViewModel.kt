package com.kotlin.practice.base

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.kotlin.practice.util.*
import javax.inject.Inject

open class BaseViewModel : ViewModel() {

    @Inject
    lateinit var stringHelper: StringHelper

    @Inject
    lateinit var toastHelper: ToastHelper

    val navigationAction = SingleLiveEvent<NavDirections>()

    fun navigate(action: NavDirections, bundle: Bundle? = null) {
        navigationAction.postValue(action)
    }

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }
}
