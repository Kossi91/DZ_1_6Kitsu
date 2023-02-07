package com.example.dz_1_6kitsu.data.models.anime_models.anime_detail

import com.example.dz_1_6kitsu.data.models.anime_models.Anime
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: Anime
)