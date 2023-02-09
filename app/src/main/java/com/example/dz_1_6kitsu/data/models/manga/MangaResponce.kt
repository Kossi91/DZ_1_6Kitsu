package com.example.dz_1_6kitsu.data.models.manga

import com.example.dz_1_6kitsu.data.models.anime.Links
import com.google.gson.annotations.SerializedName

data class MangaResponce<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: Links
)