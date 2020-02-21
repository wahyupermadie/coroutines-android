package com.godohdev.themoviedb.data.network

import com.godohdev.themoviedb.data.model.MoviesResponse
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
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
    ) : Response<MoviesResponse<MoviesResult>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") key : String,
        @Query("page") page : Int
    ) : Response<MoviesResponse<MoviesResult>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") key : String,
        @Query("page") page : Int
    ) : Response<MoviesResponse<MoviesResult>>

    @GET("movie/{movieId}/reviews")
    suspend fun getMovieReview(
        @Path("movieId") id: Int,
        @Query("api_key") key : String,
        @Query("page") page : Int
    ): Response<MoviesResponse<ReviewResult>>
}