package com.godohdev.themoviedb.data.local

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.local.dao.MoviesDao
import com.godohdev.themoviedb.data.model.MoviesResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

class LocalDataSourceImpl constructor(
    private  var moviesDao: MoviesDao
) : LocalDataSource {
    override suspend fun saveMovie(moviesResult: MoviesResult): Long {
        return moviesDao.insertMovies(moviesResult)
    }

    override fun getFavoriteMovies(): LiveData<List<MoviesResult>> {
        return moviesDao.getFavorite()
    }

    override fun getAllMovies(): LiveData<List<MoviesResult>> {
        return moviesDao.getMovies()
    }

    override fun getMovieById(id: Int): LiveData<MoviesResult> {
        return moviesDao.getMoviesById(id)
    }

    override suspend fun setFavorite(id: Int, isfavorite: Boolean): Int {
        return moviesDao.setFavorite(isfavorite, id)
    }
}