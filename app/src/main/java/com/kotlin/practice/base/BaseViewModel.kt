package com.kotlin.practice.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.kotlin.practice.util.SingleLiveEvent
import com.kotlin.practice.util.StringHelper
import com.kotlin.practice.util.ToastHelper
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
}
