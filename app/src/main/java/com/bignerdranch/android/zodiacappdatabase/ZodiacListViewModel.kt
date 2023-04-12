package com.bignerdranch.android.zodiacappdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ZodiacListViewModel : ViewModel() {
    private val crimeRepository = ZodiacRepository.get()

    private val _crimes: MutableStateFlow<List<Zodiac>> = MutableStateFlow(emptyList())
    val crimes: StateFlow<List<Zodiac>>
        get() = _crimes.asStateFlow()

    init {
        viewModelScope.launch {
            crimeRepository.getCrimes().collect {
                _crimes.value = it
            }
        }
    }
}
