package com.godohdev.themoviedb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.godohdev.themoviedb.data.local.dao.MoviesDao
import com.godohdev.themoviedb.data.model.MoviesResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Database(entities = [MoviesResult::class], exportSchema = false, version = 1)
abstract class RoomDatabaseSetup : RoomDatabase(){
    abstract fun moviesDao() : MoviesDao
}
