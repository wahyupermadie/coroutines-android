package com.godohdev.themoviedb.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.godohdev.themoviedb.BuildConfig
import com.godohdev.themoviedb.data.local.LocalDataSource
import com.godohdev.themoviedb.data.model.MoviesResponse
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.network.NetworkBoundResource
import com.godohdev.themoviedb.data.network.NetworkService
import com.godohdev.themoviedb.utils.CoroutineContextProvider
import com.godohdev.themoviedb.utils.Resource
import retrofit2.Response

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

class MovieRepositoryImpl constructor(
    private val networkService: NetworkService,
    private val localDataSource: LocalDataSource,
    private val coroutineContextProvider: CoroutineContextProvider
) : MovieRepository {
    override suspend fun getPopularMovies(): LiveData<Resource<List<MoviesResult>>> {
        return object : NetworkBoundResource<List<MoviesResult>, MoviesResponse>(){
            override suspend fun saveCallResult(item: MoviesResponse) {
                item.results?.forEach {
                    localDataSource.saveMovie(it)
                }
            }

            override fun shouldFetch(data: List<MoviesResult>?): Boolean = true

            override suspend fun createCallAsync(): Response<MoviesResponse> {
                return networkService.getPopularMovies(
                    BuildConfig.API_KEY, 1
                )
            }

            override suspend fun callFromDb(): List<MoviesResult> {
                return localDataSource.getAllMovies()
            }
        }.build().asLiveData()
    }

    override suspend fun getTopRatedMovies(): LiveData<Resource<List<MoviesResult>>> {
        return object : NetworkBoundResource<List<MoviesResult>, MoviesResponse>(){
            override suspend fun saveCallResult(item: MoviesResponse) {
                item.results?.forEach {
                    it.isTopRated = true
                    localDataSource.saveMovie(it)
                }
            }

            override fun shouldFetch(data: List<MoviesResult>?): Boolean = true

            override suspend fun createCallAsync(): Response<MoviesResponse> {
                return networkService.getTopRatedMovies(
                    BuildConfig.API_KEY, 1
                )
            }

            override suspend fun callFromDb(): List<MoviesResult> {
                return localDataSource.getTopRatedMovie()
            }
        }.build().asLiveData()
    }

    override suspend fun getNowPlayingMovies(): LiveData<Resource<List<MoviesResult>>> {
        return object : NetworkBoundResource<List<MoviesResult>, MoviesResponse>(){
            override suspend fun saveCallResult(item: MoviesResponse) {
                item.results?.forEach {
                    it.isNowPlaying = true
                    localDataSource.saveMovie(it)
                }
            }

            override fun shouldFetch(data: List<MoviesResult>?): Boolean = true

            override suspend fun createCallAsync(): Response<MoviesResponse> {
                return networkService.getNowPlayingMovies(
                    BuildConfig.API_KEY, 1
                )
            }

            override suspend fun callFromDb(): List<MoviesResult> {
                return localDataSource.getNowPlayingMovie()
            }
        }.build().asLiveData()
    }

    override suspend fun getFavoriteMovies(): LiveData<List<MoviesResult>> {
        val data = MutableLiveData<List<MoviesResult>>()
        data.value = localDataSource.getFavoriteMovies()
        return data
    }
}