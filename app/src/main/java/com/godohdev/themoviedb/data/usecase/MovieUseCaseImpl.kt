package com.godohdev.themoviedb.data.usecase

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.local.LocalDataSource
import com.godohdev.themoviedb.data.model.MoviesResponse
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.repository.MovieRepository
import com.godohdev.themoviedb.utils.Resource

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

class MovieUseCaseImpl (
    private val movieRepository: MovieRepository,
    private val localDataSource: LocalDataSource
) : MovieUseCase {
    override fun getFavoriteMovies(): LiveData<List<MoviesResult>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMovies(): LiveData<Resource<MoviesResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getTopRated(): LiveData<Resource<MoviesResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getNowPlaying(): LiveData<Resource<MoviesResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}