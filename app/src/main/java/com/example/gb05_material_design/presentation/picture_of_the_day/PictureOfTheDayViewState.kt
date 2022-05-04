package com.example.gb05_material_design.presentation.picture_of_the_day

import com.example.gb05_material_design.domain.model.PictureOfTheDay

data class PictureOfTheDayViewState(
    val loading: Boolean = true,
    val pictureOfTheDay: PictureOfTheDay? = null,
    val error: Throwable? = null,
)
