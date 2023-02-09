package com.example.dz_1_6kitsu.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz_1_6kitsu.R
import com.example.dz_1_6kitsu.base.BaseFragment
import com.example.dz_1_6kitsu.databinding.FragmentMangaBinding
import com.example.dz_1_6kitsu.ui.adapters.MangaAdapter
import com.example.dz_1_6kitsu.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel by viewModels<MangaViewModel>()
    private val mangaAdapter = MangaAdapter(this::onClickListener)

    override fun initialize() {
        binding.rvManga.adapter = mangaAdapter
    }

    private fun onClickListener(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionPagerFragmentToMangaDetailFragment(id.toInt())
        )
    }

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.getManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }
}

