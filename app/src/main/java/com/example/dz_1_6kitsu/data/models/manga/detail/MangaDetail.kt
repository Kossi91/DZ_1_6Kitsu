package com.example.dz_1_6kitsu.data.models.manga.detail

import com.example.dz_1_6kitsu.data.models.manga.Manga
import com.google.gson.annotations.SerializedName

data class MangaDetail(
    @SerializedName("data")
    val data: Manga
)