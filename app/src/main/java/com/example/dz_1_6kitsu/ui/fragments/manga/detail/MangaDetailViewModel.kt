package com.example.dz_1_6kitsu.ui.fragments.manga.detail

import com.example.dz_1_6kitsu.base.BaseViewModel
import com.example.dz_1_6kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel  @Inject constructor(private val repository: MangaRepository) : BaseViewModel() {

    fun getDetailManga(id: Int) = repository.getDetailManga(id = id)
}