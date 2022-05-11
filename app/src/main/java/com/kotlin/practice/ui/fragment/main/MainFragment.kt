package com.kotlin.practice.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kotlin.practice.databinding.FragmentMainBinding
import com.kotlin.practice.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        actionBarDrawerToggle = ActionBarDrawerToggle(requireActivity(), binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        actionBarDrawerToggle.isDrawerSlideAnimationEnabled = true
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}