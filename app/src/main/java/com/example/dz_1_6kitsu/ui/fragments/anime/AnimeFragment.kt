package com.example.dz_1_6kitsu.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz_1_6kitsu.R
import com.example.dz_1_6kitsu.base.BaseFragment
import com.example.dz_1_6kitsu.data.models.anime.Anime
import com.example.dz_1_6kitsu.databinding.FragmentAnimeBinding
import com.example.dz_1_6kitsu.extensions.toast
import com.example.dz_1_6kitsu.ui.adapters.AnimeAdapter
import com.example.dz_1_6kitsu.ui.fragments.home.HomeFragmentDirections
import com.example.dz_1_6kitsu.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(this::onClickListener)

    override fun initialize() {
        binding.rvAnime.adapter = animeAdapter
    }

    private fun onClickListener(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionPagerFragmentToDetailAnimeFragment(id.toInt())
        )
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.getAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }
}