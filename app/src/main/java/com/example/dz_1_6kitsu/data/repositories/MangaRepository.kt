package com.example.dz_1_6kitsu.data.repositories

import com.example.dz_1_6kitsu.base.BaseRepository
import com.example.dz_1_6kitsu.data.remote.api.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(private val mangaApiService: MangaApiService): BaseRepository() {

    fun getManga() = doRequest {
        mangaApiService.getManga()
    }

    fun getDetailManga(id : Int) = doRequest {
       mangaApiService.getDetailManga(id = id)
    }
}