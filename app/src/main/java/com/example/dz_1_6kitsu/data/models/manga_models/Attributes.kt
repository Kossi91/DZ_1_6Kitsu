package com.example.dz_1_6kitsu.data.models.manga_models

import com.example.dz_1_6kitsu.data.models.anime_models.PosterImage
import com.example.dz_1_6kitsu.data.models.anime_models.Titles
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("status")
    val status: String = ""
)