package com.example.dz_1_6kitsu.data.models.detail

import com.example.dz_1_6kitsu.data.models.get.Anime
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: Anime
)