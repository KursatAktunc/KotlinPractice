package com.kotlin.practice

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.findNavController
import com.kotlin.practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideSystemBar()
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)   //Dene
        return navController.navigateUp() || super.onSupportNavigateUp()
    }*/

    private fun hideSystemBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN //geçici kod

        WindowInsetsControllerCompat(
            window,
            binding.root
        ).let { controller ->  //alt kısımdaki kontrol butonlarını gizler
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    override fun onResume() {
        hideSystemBar()
        super.onResume()
    }
}