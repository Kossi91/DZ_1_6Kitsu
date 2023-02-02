package com.example.dz_1_6kitsu.data.repositories

import androidx.lifecycle.liveData
import com.example.dz_1_6kitsu.data.remote.api.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApiService: AnimeApiService) {

    fun getAnime() = liveData {
        emit(animeApiService.getAnime())
    }

    fun getDetailAnime(id : Int) = liveData {
        emit(animeApiService.getDetailAnime(id = id))
    }
}