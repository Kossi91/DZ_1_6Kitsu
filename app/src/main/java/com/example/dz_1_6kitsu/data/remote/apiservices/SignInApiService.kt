package com.example.dz_1_6kitsu.data.remote.apiservices

import com.example.dz_1_6kitsu.data.models.auth.AuthModel
import com.example.dz_1_6kitsu.data.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}
