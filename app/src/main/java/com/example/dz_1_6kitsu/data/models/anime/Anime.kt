package com.example.dz_1_6kitsu.data.models.anime

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)