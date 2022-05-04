package com.example.gb04_android_on_kotlin_movie_finder.data.api.interceptor

import com.example.gb05_material_design.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NasaApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.NASA_API_KEY)
            .build()

        val newRequest = chain.request().newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}