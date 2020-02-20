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
    fun getPopularMovies() : LiveData<Resource<MoviesResponse>>
    fun getTopRatedMovies() : LiveData<Resource<MoviesResponse>>
    fun getNowPlayingMovies() : LiveData<Resource<MoviesResponse>>
    fun getFavoriteMovies() : LiveData<Resource<List<MoviesResult>>>
}