package com.example.dz_1_6kitsu.data.models.manga_models

import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)