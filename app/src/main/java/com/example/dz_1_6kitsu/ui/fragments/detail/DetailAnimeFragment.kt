package com.example.dz_1_6kitsu.ui.fragments.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.dz_1_6kitsu.R
import com.example.dz_1_6kitsu.databinding.FragmentDetailAnimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailAnimeFragment : Fragment(R.layout.fragment_detail_anime) {

    private val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    private val viewModel by viewModels<DetailAnimeViewModel>()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserve()
    }

    private fun setupObserve() = with(binding) {
        viewModel.getDetailAnime(args.id).observe(viewLifecycleOwner) {
            Glide.with(ivPoster.context)
                .load(it.data.attributes.posterImage.large)
                .into(ivPoster)

            tvName.text = it.data.attributes.titles.enJp
        }
    }
}