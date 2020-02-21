package com.godohdev.themoviedb.data.local

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.model.MoviesResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

interface LocalDataSource {
    suspend fun saveMovie(moviesResult: MoviesResult) : Long
    suspend fun getFavoriteMovies() : List<MoviesResult>
    suspend fun getAllMovies() : List<MoviesResult>
    suspend fun getTopRatedMovie() : List<MoviesResult>
    suspend fun getNowPlayingMovie() : List<MoviesResult>
    suspend fun getMovieById(id: Int) : LiveData<MoviesResult>
    suspend fun setFavorite(id:Int, isfavorite:Boolean) : Int
}