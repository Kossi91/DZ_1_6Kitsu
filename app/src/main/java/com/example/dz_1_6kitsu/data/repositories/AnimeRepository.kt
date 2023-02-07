package com.example.dz_1_6kitsu.data.repositories

import com.example.dz_1_6kitsu.base.BaseRepository
import com.example.dz_1_6kitsu.data.remote.api.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApiService: AnimeApiService): BaseRepository() {

    fun getAnime() = doRequest {
        animeApiService.getAnime()
    }

    fun getDetailAnime(id : Int) = doRequest {
       animeApiService.getDetailAnime(id = id)
    }
}