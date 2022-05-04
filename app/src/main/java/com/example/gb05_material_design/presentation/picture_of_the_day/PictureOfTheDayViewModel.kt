package com.example.gb05_material_design.presentation.picture_of_the_day

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gb05_material_design.data.NasaRepository
import com.example.gb05_material_design.domain.INasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureOfTheDayViewModel @Inject constructor(private val nasaRepository: INasaRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(PictureOfTheDayViewState())
    val uiState = _uiState.asStateFlow()

    fun requestPictureOfTheDay() = viewModelScope.launch {
        _uiState.update { it.copy(loading = true, pictureOfTheDay = null, error = null) }
        try {
            val pictureOfTheDay = nasaRepository.requestPictureOfTheDay()
            _uiState.update { it.copy(loading = false, pictureOfTheDay = pictureOfTheDay) }
        } catch (error: Exception) {
            _uiState.update { it.copy(loading = false, error = error) }
        }
    }
}