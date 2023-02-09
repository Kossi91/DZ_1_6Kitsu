package com.example.dz_1_6kitsu.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.dz_1_6kitsu.data.models.manga.Manga
import com.example.dz_1_6kitsu.data.remote.apiservices.MangaApiService
import java.io.IOException

const val DEFAULT_LIMIT_NUMBER = 1

class MangaPagingSource(private val service: MangaApiService) : PagingSource<Int, Manga>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Manga> {
        val page = params.key ?: DEFAULT_LIMIT_NUMBER
        return try {
            val response =
                service.getManga(params.loadSize, page)
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

    override fun getRefreshKey(state: PagingState<Int, Manga>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}