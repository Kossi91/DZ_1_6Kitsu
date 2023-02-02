package com.example.dz_1_6kitsu.data.models.get

import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("en")
    val en: String,
    @SerializedName("ja_jp")
    val jaJp: String = "",
    @SerializedName("en_jp")
    val enJp: String = ""
)