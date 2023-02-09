package com.example.dz_1_6kitsu.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.dz_1_6kitsu.data.models.anime.Anime
import com.example.dz_1_6kitsu.data.remote.apiservices.AnimeApiService
import java.io.IOException

const val DEFAULT_PAGE_NUMBER = 1

class AnimePagingSource(private val service: AnimeApiService) : PagingSource<Int, Anime>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val page = params.key ?: DEFAULT_PAGE_NUMBER
       return try {
            val response =
                service.getAnime(params.loadSize , page)
            val nextPage = if (response.links.next == null) {
                null
            } else
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
             LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
