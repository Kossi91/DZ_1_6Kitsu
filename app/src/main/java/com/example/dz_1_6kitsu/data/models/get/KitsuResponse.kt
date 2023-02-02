package com.example.dz_1_6kitsu.data.models.get

import com.google.gson.annotations.SerializedName

data class KitsuResponse<T>(

    @SerializedName("data")
    val data: List<T>?
)