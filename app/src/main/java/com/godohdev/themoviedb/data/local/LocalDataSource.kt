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
    fun getFavoriteMovies() : LiveData<List<MoviesResult>>
    fun getAllMovies() : LiveData<List<MoviesResult>>
    fun getMovieById(id: Int) : LiveData<MoviesResult>
    suspend fun setFavorite(id:Int, isfavorite:Boolean) : Int
}