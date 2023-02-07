package com.example.dz_1_6kitsu.data.models.manga_models.manga_detail

import com.example.dz_1_6kitsu.data.models.manga_models.Manga
import com.google.gson.annotations.SerializedName

data class MangaDetail(
    @SerializedName("data")
    val data: Manga
)