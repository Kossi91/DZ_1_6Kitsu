package com.example.dz_1_6kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz_1_6kitsu.data.models.manga.Manga
import com.example.dz_1_6kitsu.databinding.ItemMangaBinding

class MangaAdapter(private val onClickListener: (id: String) -> Unit) :
    PagingDataAdapter<Manga, MangaAdapter.MangeViewHolder>(diffUtil) {

    inner class MangeViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply {
                    onClickListener(id)
                }
            }
        }

        fun onBind(item: Manga) {
            Glide.with(binding.imageIcon.context)
                .load(item.attributes.posterImage.original)
                .into(binding.imageIcon)

            binding.nameManga.text = item.attributes.titles.enJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangeViewHolder {
        return MangeViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MangeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Manga>() {
            override fun areItemsTheSame(oldItem: Manga, newItem: Manga): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Manga, newItem: Manga): Boolean {
                return oldItem == newItem
            }
        }
    }
}