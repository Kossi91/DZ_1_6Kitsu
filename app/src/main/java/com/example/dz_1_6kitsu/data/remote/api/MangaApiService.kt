package com.example.dz_1_6kitsu.data.remote.api

import com.example.dz_1_6kitsu.data.models.manga_models.Manga
import com.example.dz_1_6kitsu.data.models.manga_models.MangaResponce
import com.example.dz_1_6kitsu.data.models.manga_models.manga_detail.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApiService {

    @GET("manga")
    suspend fun getManga(): MangaResponce<Manga>

    @GET("manga/{id}")
    suspend fun getDetailManga(
        @Path("id") id: Int
    ): MangaDetail
}