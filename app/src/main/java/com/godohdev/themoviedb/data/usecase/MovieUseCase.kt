package com.godohdev.themoviedb.data.usecase

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult
import com.godohdev.themoviedb.utils.Resource

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

interface MovieUseCase {
    suspend fun getFavoriteMovies() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getMovies() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getTopRated() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getNowPlaying() : LiveData<Resource<List<MoviesResult>>>
    suspend fun getReviewByMovieId(id: Int) : LiveData<Resource<List<ReviewResult>>>
    suspend fun getMovieById(id: Int) : LiveData<MoviesResult>
    suspend fun setFavorite(isFavorite: Boolean, id: Int) : LiveData<MoviesResult>
}