package com.example.dz_1_6kitsu.data.remote.apiservices

import com.example.dz_1_6kitsu.data.models.anime.Anime
import com.example.dz_1_6kitsu.data.models.anime.AnimeResponce
import com.example.dz_1_6kitsu.data.models.anime.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun getAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponce<Anime>

    @GET("edge/anime/{id}")
    suspend fun getDetailAnime(
        @Path("id") id: Int
    ): AnimeDetail
}