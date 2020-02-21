package com.godohdev.themoviedb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.godohdev.themoviedb.data.local.dao.MoviesDao
import com.godohdev.themoviedb.data.local.dao.ReviewDao
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Database(entities = [MoviesResult::class, ReviewResult::class], exportSchema = false, version = 2)
abstract class RoomDatabaseSetup : RoomDatabase(){
    abstract fun moviesDao() : MoviesDao
    abstract fun reviewDao() : ReviewDao
}
