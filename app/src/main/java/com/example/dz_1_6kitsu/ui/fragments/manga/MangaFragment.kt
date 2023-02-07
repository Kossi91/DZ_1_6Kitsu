package com.example.dz_1_6kitsu.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz_1_6kitsu.R
import com.example.dz_1_6kitsu.base.BaseFragment
import com.example.dz_1_6kitsu.databinding.FragmentMangaBinding
import com.example.dz_1_6kitsu.extensions.toast
import com.example.dz_1_6kitsu.ui.adapters.MangaAdapter
import com.example.dz_1_6kitsu.ui.fragments.pager.PagerFragmentDirections
import com.example.dz_1_6kitsu.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel by viewModels<MangaViewModel>()
    private val mangaAdapter = MangaAdapter(this::onClickListener)

    override fun initialize() {
        binding.rvManga.adapter = mangaAdapter
    }

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.getManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {
                    toast(it.message)
                }
                is Resource.Loading -> {
                    toast("Загрузка...")
                }
                is Resource.Success -> {
                    mangaAdapter.submitList(it.data?.data)
                    toast("Успешно")
                }
            }
        }
    }

    private fun onClickListener(id: String) {
        findNavController().navigate(
            PagerFragmentDirections.actionPagerFragmentToMangaDetailFragment(id.toInt())
        )
    }
}