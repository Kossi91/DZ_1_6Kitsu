package com.example.dz_1_6kitsu.ui.fragments.manga

import com.example.dz_1_6kitsu.base.BaseViewModel
import com.example.dz_1_6kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: MangaRepository) : BaseViewModel() {

    fun getManga() = repository.getManga()
}