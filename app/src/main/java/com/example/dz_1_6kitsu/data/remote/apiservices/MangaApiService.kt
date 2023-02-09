package com.example.dz_1_6kitsu.data.remote.apiservices

import com.example.dz_1_6kitsu.data.models.manga.Manga
import com.example.dz_1_6kitsu.data.models.manga.MangaResponce
import com.example.dz_1_6kitsu.data.models.manga.detail.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun getManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): MangaResponce<Manga>

    @GET("edge/manga/{id}")
    suspend fun getDetailManga(
        @Path("id") id: Int
    ): MangaDetail
}