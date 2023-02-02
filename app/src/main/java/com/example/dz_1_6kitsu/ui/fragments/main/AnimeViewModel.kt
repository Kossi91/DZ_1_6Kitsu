package com.example.dz_1_6kitsu.ui.fragments.main

import androidx.lifecycle.ViewModel
import com.example.dz_1_6kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

     fun getAnime() = repository.getAnime()
}