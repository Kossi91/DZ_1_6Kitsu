package com.example.dz_1_6kitsu.base

import androidx.lifecycle.liveData
import com.example.dz_1_6kitsu.utils.Resource

abstract class BaseRepository {
    protected open fun <T> doRequest(request: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: Exception) {
            emit(Resource.Failure(null ,ioException.localizedMessage ?: "Error"))
        }
    }
}