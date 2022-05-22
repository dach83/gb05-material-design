package com.example.gb05_material_design.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gb05_material_design.R
import com.example.gb05_material_design.databinding.ActivityMainBinding
import com.example.gb05_material_design.domain.ThemePreferencesHelper
import com.example.gb05_material_design.presentation.picture_of_the_day.PictureOfTheDayFragment
import com.example.gb05_material_design.presentation.picture_of_the_day_pager.PictureOfTheDayPagerFragment
import com.example.gb05_material_design.presentation.switch_theme.SwitchThemeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTheme()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupTheme() {
        val themeId = ThemePreferencesHelper.readTheme(this)
        setTheme(themeId)
    }

    private fun setupBottomNav() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.picture_of_the_day_menu -> PictureOfTheDayPagerFragment()
                R.id.switch_theme_menu -> SwitchThemeFragment()
                else -> null
            }?.also { fragment ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, fragment)
                    .commit()
            }
            true
        }
    }

}