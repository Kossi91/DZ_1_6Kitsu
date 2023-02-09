package com.example.dz_1_6kitsu.data.repositories

import com.example.dz_1_6kitsu.base.BaseRepository
import com.example.dz_1_6kitsu.data.models.auth.AuthModel
import com.example.dz_1_6kitsu.data.remote.apiservices.SignInApiService
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val api: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        api.postAuthDataUser(authModel)
    }
}