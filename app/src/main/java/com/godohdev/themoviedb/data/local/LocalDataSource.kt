package com.godohdev.themoviedb.data.local

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

interface LocalDataSource {
    suspend fun saveReview(reviewResult: ReviewResult) : Long
    suspend fun getReviewByMovieId(id: Int) : List<ReviewResult>
    suspend fun saveMovie(moviesResult: MoviesResult) : Long
    suspend fun getFavoriteMovies() : List<MoviesResult>
    suspend fun getAllMovies() : List<MoviesResult>
    suspend fun getTopRatedMovie() : List<MoviesResult>
    suspend fun getNowPlayingMovie() : List<MoviesResult>
    suspend fun getMovieById(id: Int) : MoviesResult
    suspend fun setFavorite(id:Int, isfavorite:Boolean) : Int
}