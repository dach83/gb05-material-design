package com.example.gb05_material_design.data

import android.text.format.DateUtils
import com.example.gb05_material_design.data.nasa_api.NasaApiService
import com.example.gb05_material_design.data.nasa_api.mapper.PictureOfTheDayMapper
import com.example.gb05_material_design.domain.INasaRepository
import com.example.gb05_material_design.domain.model.PictureOfTheDay
import com.example.gb05_material_design.utils.minusDays
import com.example.gb05_material_design.utils.toQueryString
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

class NasaRepository @Inject constructor(
    private val nasaApiService: NasaApiService,
    private val pictureOfTheDayMapper: PictureOfTheDayMapper
) : INasaRepository {
    override suspend fun requestPictureOfTheDay(daysAgo: Int): PictureOfTheDay =
        pictureOfTheDayMapper.mapToDomain(nasaApiService.requestPictureOfTheDay(Date().minusDays(daysAgo).toQueryString()))
}