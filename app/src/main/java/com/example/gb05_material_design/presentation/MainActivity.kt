package com.example.gb05_material_design.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gb05_material_design.R
import com.example.gb05_material_design.domain.ThemePreferencesHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTheme()
        setContentView(R.layout.activity_main)
    }

    private fun setupTheme() {
        val themeId = ThemePreferencesHelper.readTheme(this)
        setTheme(themeId)
    }

}