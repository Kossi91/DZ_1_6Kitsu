package com.example.dz_1_6kitsu.ui.fragments.anime.detail

import com.example.dz_1_6kitsu.base.BaseViewModel
import com.example.dz_1_6kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeViewModel  @Inject constructor(private val repository: AnimeRepository) : BaseViewModel() {

    fun getDetailAnime(id: Int) = repository.getDetailAnime(id = id)
}