package com.kotlin.practice.ui.fragment.appintro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kotlin.practice.databinding.FragmentAppIntroBinding
import com.kotlin.practice.viewmodel.AppIntroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppIntroFragment : Fragment() {

    private var _binding: FragmentAppIntroBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AppIntroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppIntroBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[AppIntroViewModel::class.java]

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}