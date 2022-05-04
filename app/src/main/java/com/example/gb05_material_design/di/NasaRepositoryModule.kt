package com.example.gb05_material_design.di

import com.example.gb05_material_design.data.NasaRepository
import com.example.gb05_material_design.domain.INasaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NasaRepositoryModule {
    @Binds
    abstract fun bindNasaRepository(nasaRepository: NasaRepository): INasaRepository
}