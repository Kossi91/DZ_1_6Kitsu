package com.example.dz_1_6kitsu.ui.fragments.singin

import com.example.dz_1_6kitsu.base.BaseViewModel
import com.example.dz_1_6kitsu.data.models.auth.AuthModel
import com.example.dz_1_6kitsu.data.repositories.PostUserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: PostUserDataRepository
): BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}