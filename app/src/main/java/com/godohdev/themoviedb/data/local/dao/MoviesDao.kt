package com.godohdev.themoviedb.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.godohdev.themoviedb.data.model.MoviesResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movie_table WHERE isTopRated=:topRated AND isNowPlaying=:nowPlaying ")
    suspend fun getMovies(nowPlaying: Boolean? = false, topRated: Boolean? = false) : List<MoviesResult>

    @Insert(onConflict = IGNORE)
    suspend fun insertMovies(movies: MoviesResult) : Long

    @Query("SELECT * FROM movie_table WHERE id = :id")
    suspend fun getMoviesById(id : Int): MoviesResult

    @Query("UPDATE movie_table SET isFavorite = :favorite WHERE id = :id")
    suspend fun setFavorite(favorite: Boolean, id : Int) : Int

    @Query("SELECT * FROM movie_table WHERE isFavorite = :favorite")
    suspend fun getFavorite(favorite: Boolean? = true) : List<MoviesResult>

    @Query("SELECT * FROM movie_table WHERE isNowPlaying = :nowPlaying")
    suspend fun getNowPlaying(nowPlaying: Boolean? = true) : List<MoviesResult>

    @Query("SELECT * FROM movie_table WHERE isTopRated = :topRated")
    suspend fun getTopRated(topRated: Boolean? = true) : List<MoviesResult>
}