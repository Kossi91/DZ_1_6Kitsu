package com.example.dz_1_6kitsu.data.remote.api

import com.example.dz_1_6kitsu.data.models.anime_models.anime_detail.AnimeDetail
import com.example.dz_1_6kitsu.data.models.anime_models.Anime
import com.example.dz_1_6kitsu.data.models.anime_models.AnimeResponce
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun getAnime(): AnimeResponce<Anime>

    @GET("anime/{id}")
    suspend fun getDetailAnime(
        @Path("id") id: Int
    ): AnimeDetail
}