package com.example.gb05_material_design.data.nasa_api.mapper

import com.example.gb05_material_design.data.nasa_api.model.ApiPictureOfTheDay
import com.example.gb05_material_design.domain.model.PictureOfTheDay
import javax.inject.Inject

class PictureOfTheDayMapper @Inject constructor() {
    fun mapToDomain(apiPictureOfTheDay: ApiPictureOfTheDay): PictureOfTheDay =
        PictureOfTheDay(apiPictureOfTheDay.url)
}