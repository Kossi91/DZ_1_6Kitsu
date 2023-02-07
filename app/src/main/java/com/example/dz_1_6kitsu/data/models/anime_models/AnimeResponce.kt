package com.example.dz_1_6kitsu.data.models.anime_models

import com.google.gson.annotations.SerializedName

data class AnimeResponce<T>(@SerializedName("data")
                         val data: List<T>,
)