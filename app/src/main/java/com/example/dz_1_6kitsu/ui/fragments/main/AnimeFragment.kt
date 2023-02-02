package com.example.dz_1_6kitsu.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz_1_6kitsu.R
import com.example.dz_1_6kitsu.databinding.FragmentAnimeBinding
import com.example.dz_1_6kitsu.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(this::onClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.recyclerView.adapter = animeAdapter
    }

    private fun onClickListener(id: String) {
        findNavController().navigate(
            AnimeFragmentDirections.actionKitsuFragmentToDetailAnimeFragment(id.toInt())
        )
    }

    private fun setupObserve() {
        viewModel.getAnime().observe(viewLifecycleOwner) {
            animeAdapter.submitList(it.data)
        }
    }
}