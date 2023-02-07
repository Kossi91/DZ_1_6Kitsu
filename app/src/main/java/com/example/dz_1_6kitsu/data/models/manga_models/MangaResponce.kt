package com.example.dz_1_6kitsu.data.models.manga_models

import com.google.gson.annotations.SerializedName

data class MangaResponce<T>(@SerializedName("data")
                         val data: List<T>,
)