package com.example.dz_1_6kitsu.data.models.anime.detail

import com.example.dz_1_6kitsu.data.models.anime.Anime
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: Anime
)