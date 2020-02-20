package com.godohdev.themoviedb.di.modul

import android.content.Context
import androidx.room.Room
import com.godohdev.themoviedb.data.local.LocalDataSourceImpl
import com.godohdev.themoviedb.data.local.RoomDatabaseSetup
import com.godohdev.themoviedb.data.local.dao.MoviesDao
import com.godohdev.themoviedb.data.network.NetworkService
import com.godohdev.themoviedb.data.repository.MovieRepositoryImpl
import com.godohdev.themoviedb.data.usecase.MovieUseCaseImpl
import com.godohdev.themoviedb.utils.AppCoroutineContextProvider
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
    fun provideAppCouroutineContextProvider() : AppCoroutineContextProvider = AppCoroutineContextProvider()

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

    @Provides
    @Singleton
    fun provideLocalDataSource(
        moviesDao: MoviesDao
    ) : LocalDataSourceImpl = LocalDataSourceImpl(moviesDao)

    @Provides
    @Singleton
    fun provideMovieRepository(
        localDataSourceImpl: LocalDataSourceImpl,
        appCoroutineContextProvider: AppCoroutineContextProvider,
        networkService: NetworkService
    ) : MovieRepositoryImpl = MovieRepositoryImpl(
        networkService,
        localDataSourceImpl,
        appCoroutineContextProvider
    )

    @Provides
    @Singleton
    fun provideMovieUseCaseImpl(
        localDataSourceImpl: LocalDataSourceImpl,
        movieRepositoryImpl: MovieRepositoryImpl
    ) : MovieUseCaseImpl = MovieUseCaseImpl(
        movieRepositoryImpl,
        localDataSourceImpl
    )
}