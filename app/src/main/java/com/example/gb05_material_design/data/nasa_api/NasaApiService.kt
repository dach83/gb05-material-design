package com.example.gb05_material_design.data.nasa_api

import com.example.gb05_material_design.data.nasa_api.model.ApiPictureOfTheDay
import retrofit2.http.GET

interface NasaApiService {
    @GET("planetary/apod")
    suspend fun requestPictureOfTheDay(): ApiPictureOfTheDay
}