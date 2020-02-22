package com.godohdev.themoviedb.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.godohdev.themoviedb.BuildConfig
import com.godohdev.themoviedb.data.local.LocalDataSource
import com.godohdev.themoviedb.data.model.MoviesResponse
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult
import com.godohdev.themoviedb.data.network.NetworkBoundResource
import com.godohdev.themoviedb.data.network.NetworkService
import com.godohdev.themoviedb.utils.Resource
import com.godohdev.themoviedb.utils.isConnected
import retrofit2.Response

class MovieRepositoryImpl constructor(
    private val networkService: NetworkService,
    private val localDataSource: LocalDataSource,
    private val context: Application
) : MovieRepository {
    override suspend fun getPopularMovies(): LiveData<Resource<List<MoviesResult>>> {
        return object : NetworkBoundResource<List<MoviesResult>, MoviesResponse<MoviesResult>>(){
            override suspend fun saveCallResult(item: MoviesResponse<MoviesResult>) {
                item.results?.forEach {
                    localDataSource.saveMovie(it)
                }
            }

            override fun shouldFetch(data: List<MoviesResult>?): Boolean = isConnected(context)

            override suspend fun createCallAsync(): Response<MoviesResponse<MoviesResult>> {
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
        return object : NetworkBoundResource<List<MoviesResult>, MoviesResponse<MoviesResult>>(){
            override suspend fun saveCallResult(item: MoviesResponse<MoviesResult>) {
                item.results?.forEach {
                    it.isTopRated = true
                    localDataSource.saveMovie(it)
                }
            }

            override fun shouldFetch(data: List<MoviesResult>?): Boolean = isConnected(context)

            override suspend fun createCallAsync(): Response<MoviesResponse<MoviesResult>> {
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
        return object : NetworkBoundResource<List<MoviesResult>, MoviesResponse<MoviesResult>>(){
            override suspend fun saveCallResult(item: MoviesResponse<MoviesResult>) {
                item.results?.forEach {
                    it.isNowPlaying = true
                    localDataSource.saveMovie(it)
                }
            }

            override fun shouldFetch(data: List<MoviesResult>?): Boolean = isConnected(context)

            override suspend fun createCallAsync(): Response<MoviesResponse<MoviesResult>> {
                return networkService.getNowPlayingMovies(
                    BuildConfig.API_KEY, 1
                )
            }

            override suspend fun callFromDb(): List<MoviesResult> {
                return localDataSource.getNowPlayingMovie()
            }
        }.build().asLiveData()
    }

    override suspend fun getFavoriteMovies(): LiveData<Resource<List<MoviesResult>>> {
        val data = MutableLiveData<Resource<List<MoviesResult>>>()
        data.postValue(Resource.success(localDataSource.getFavoriteMovies()))
        return data
    }

    override suspend fun getReviewMovie(id: Int): LiveData<Resource<List<ReviewResult>>> {
        return object : NetworkBoundResource<List<ReviewResult>, MoviesResponse<ReviewResult>>(){
            override suspend fun saveCallResult(item: MoviesResponse<ReviewResult>) {
                item.results?.forEach {
                    it.movieId = id
                    localDataSource.saveReview(it)
                }
            }

            override fun shouldFetch(data: List<ReviewResult>?): Boolean = isConnected(context)

            override suspend fun createCallAsync(): Response<MoviesResponse<ReviewResult>> {
                return networkService.getMovieReview(id,
                    BuildConfig.API_KEY, 1
                )
            }

            override suspend fun callFromDb(): List<ReviewResult> {
                return localDataSource.getReviewByMovieId(id)
            }
        }.build().asLiveData()
    }

    override suspend fun getMovieId(id: Int): LiveData<MoviesResult> {
        val data = MutableLiveData<MoviesResult>()
        data.postValue(localDataSource.getMovieById(id))
        return data
    }

    override suspend fun setMovieFavoriteId(isFavorite: Boolean, id: Int): LiveData<MoviesResult> {
        localDataSource.setFavorite(id, isFavorite)
        val data = MutableLiveData<MoviesResult>()
        data.postValue(localDataSource.getMovieById(id))
        return data
    }
}