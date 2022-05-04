package com.example.gb05_material_design.data

import com.example.gb05_material_design.data.nasa_api.NasaApiService
import com.example.gb05_material_design.data.nasa_api.mapper.PictureOfTheDayMapper
import com.example.gb05_material_design.domain.INasaRepository
import com.example.gb05_material_design.domain.model.PictureOfTheDay
import javax.inject.Inject

class NasaRepository @Inject constructor(
    private val nasaApiService: NasaApiService,
    private val pictureOfTheDayMapper: PictureOfTheDayMapper
) : INasaRepository {
    override suspend fun requestPictureOfTheDay(): PictureOfTheDay =
        pictureOfTheDayMapper.mapToDomain(nasaApiService.requestPictureOfTheDay())
}