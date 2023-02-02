package com.example.dz_1_6kitsu.data.remote.api

import com.example.dz_1_6kitsu.data.models.detail.AnimeDetail
import com.example.dz_1_6kitsu.data.models.get.Anime
import com.example.dz_1_6kitsu.data.models.get.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun getAnime(): KitsuResponse<Anime>

    @GET("anime/{id}")
    suspend fun getDetailAnime(
        @Path("id") id: Int
    ): AnimeDetail
}