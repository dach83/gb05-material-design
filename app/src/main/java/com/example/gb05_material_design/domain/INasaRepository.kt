package com.example.gb05_material_design.domain

import com.example.gb05_material_design.domain.model.PictureOfTheDay

interface INasaRepository {
    suspend fun requestPictureOfTheDay(): PictureOfTheDay
}