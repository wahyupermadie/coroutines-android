package com.godohdev.themoviedb.data.network

import com.godohdev.themoviedb.data.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

interface NetworkService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key : String,
        @Query("page") page : Int
    ) : Response<MoviesResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") key : String,
        @Query("page") page : Int
    ) : Response<MoviesResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") key : String,
        @Query("page") page : Int
    ) : Response<MoviesResponse>
}