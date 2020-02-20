package com.godohdev.themoviedb.di.modul

import android.content.Context
import androidx.room.Room
import com.godohdev.themoviedb.data.local.RoomDatabaseSetup
import com.godohdev.themoviedb.data.local.dao.MoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context) : RoomDatabaseSetup =
        Room.databaseBuilder(context, RoomDatabaseSetup::class.java, "db_movies")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMoviesDao(roomDatabaseSetup: RoomDatabaseSetup) : MoviesDao {
        return roomDatabaseSetup.moviesDao()
    }
}