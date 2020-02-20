package com.godohdev.themoviedb.data.local.dao

import androidx.lifecycle.LiveData
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

    @Query("SELECT * FROM movie_table")
    fun getMovies() : LiveData<List<MoviesResult>>

    @Insert(onConflict = IGNORE)
    suspend fun insertMovies(movies: MoviesResult) : Long

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMoviesById(id : Int): LiveData<MoviesResult>

    @Query("UPDATE movie_table SET isFavorite = :favorite WHERE id = :id")
    suspend fun setFavorite(favorite: Boolean, id : Int) : Int

    @Query("SELECT * FROM movie_table WHERE isFavorite = :favorite")
    fun getFavorite(favorite: Boolean? = true) : LiveData<List<MoviesResult>>
}