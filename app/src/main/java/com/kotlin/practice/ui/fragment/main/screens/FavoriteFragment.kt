package com.kotlin.practice.ui.fragment.main.screens

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentFavoriteBinding
import com.kotlin.practice.viewmodel.FavoriteFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG: String = "FavoriteFragment"

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteFragmentViewModel>() {

    override val mViewModel: FavoriteFragmentViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_favorite

    override fun initViews() {
        mBinding.floatingActionButton.setOnClickListener {
            Toast.makeText(context, "Test Clicked", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Test Log")
        }
    }
}