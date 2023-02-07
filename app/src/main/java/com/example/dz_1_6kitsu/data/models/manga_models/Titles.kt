package com.example.dz_1_6kitsu.data.models.manga_models

import com.google.gson.annotations.SerializedName

data class Titles(@SerializedName("en_us")
                  val enUs: String = "",
                  @SerializedName("en_jp")
                  val enJp: String = "")