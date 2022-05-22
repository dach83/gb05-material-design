package com.example.gb05_material_design.presentation.picture_of_the_day_pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gb05_material_design.domain.model.PictureOfTheDayPreset
import com.example.gb05_material_design.presentation.picture_of_the_day.PictureOfTheDayFragment

class PictureOfTheDayPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = PictureOfTheDayPreset.values().size

    override fun createFragment(position: Int): Fragment = PictureOfTheDayFragment
        .newInstance(PictureOfTheDayPreset.values()[position])
}