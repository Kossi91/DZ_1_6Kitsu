package com.example.dz_1_6kitsu.ui.fragments.anime

import com.example.dz_1_6kitsu.base.BaseViewModel
import com.example.dz_1_6kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) : BaseViewModel() {

     fun getAnime() = repository.getAnime()
}