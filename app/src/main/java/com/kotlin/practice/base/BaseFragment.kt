package com.kotlin.practice.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<T : ViewDataBinding, VM : BaseViewModel>() : Fragment() {

    lateinit var mBinding : T

    abstract val mViewModel : VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, bindLayoutId(),container,false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.navigationAction.observe(viewLifecycleOwner){
            findNavController().navigate(it)
        }
        initViews()
    }

    protected abstract fun bindLayoutId() : Int

    protected abstract fun initViews()

}