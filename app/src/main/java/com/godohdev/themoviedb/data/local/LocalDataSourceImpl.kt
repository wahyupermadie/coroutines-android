package com.godohdev.themoviedb.data.local

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.local.dao.MoviesDao
import com.godohdev.themoviedb.data.local.dao.ReviewDao
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

class LocalDataSourceImpl constructor(
    private var moviesDao: MoviesDao,
    private var reviewDao: ReviewDao
) : LocalDataSource {
    override suspend fun saveReview(reviewResult: ReviewResult): Long {
        return reviewDao.insertReview(reviewResult)
    }

    override suspend fun getReviewByMovieId(id: Int): List<ReviewResult> {
        return reviewDao.getReviewByMovieId(id)
    }

    override suspend fun saveMovie(moviesResult: MoviesResult): Long {
        return moviesDao.insertMovies(moviesResult)
    }

    override suspend fun getFavoriteMovies(): List<MoviesResult> {
        return moviesDao.getFavorite()
    }

    override suspend fun getAllMovies(): List<MoviesResult> {
        return moviesDao.getMovies()
    }

    override suspend fun getTopRatedMovie(): List<MoviesResult> {
        return moviesDao.getTopRated()
    }

    override suspend fun getNowPlayingMovie(): List<MoviesResult> {
        return moviesDao.getNowPlaying()
    }

    override suspend fun getMovieById(id: Int): MoviesResult {
        return moviesDao.getMoviesById(id)
    }

    override suspend fun setFavorite(id: Int, isfavorite: Boolean): Int {
        return moviesDao.setFavorite(isfavorite, id)
    }
}