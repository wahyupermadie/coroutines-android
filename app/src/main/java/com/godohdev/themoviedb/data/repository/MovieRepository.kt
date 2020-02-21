package com.godohdev.themoviedb.data.repository

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.model.MoviesResponse
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.utils.Resource

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

interface MovieRepository {
    suspend fun getPopularMovies() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getTopRatedMovies() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getNowPlayingMovies() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getFavoriteMovies() : LiveData<List<MoviesResult>>
}