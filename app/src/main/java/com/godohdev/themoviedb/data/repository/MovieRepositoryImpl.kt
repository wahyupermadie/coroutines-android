package com.godohdev.themoviedb.data.repository

import androidx.lifecycle.LiveData
import com.godohdev.themoviedb.data.local.LocalDataSource
import com.godohdev.themoviedb.data.model.MoviesResponse
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.network.NetworkService
import com.godohdev.themoviedb.utils.CoroutineContextProvider
import com.godohdev.themoviedb.utils.Resource

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

class MovieRepositoryImpl constructor(
    private val networkService: NetworkService,
    private val localDataSource: LocalDataSource,
    coroutineContextProvider: CoroutineContextProvider
) : MovieRepository {
    override fun getPopularMovies(): LiveData<Resource<MoviesResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTopRatedMovies(): LiveData<Resource<MoviesResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNowPlayingMovies(): LiveData<Resource<MoviesResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoriteMovies(): LiveData<Resource<List<MoviesResult>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}