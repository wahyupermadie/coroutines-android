package com.godohdev.themoviedb.data.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult
import com.godohdev.themoviedb.data.repository.MovieRepository
import com.godohdev.themoviedb.utils.Resource

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

class MovieUseCaseImpl (
    private val movieRepository: MovieRepository
) : MovieUseCase {
    override suspend fun getFavoriteMovies(): LiveData<Resource<List<MoviesResult>>> {
        return movieRepository.getFavoriteMovies()
    }

    override suspend fun getMovies(): LiveData<Resource<List<MoviesResult>>> {
        return Transformations.map(movieRepository.getPopularMovies()){
            it
        }
    }

    override suspend fun getTopRated(): LiveData<Resource<List<MoviesResult>>> {
        return Transformations.map(movieRepository.getTopRatedMovies()){
            it
        }
    }

    override suspend fun getNowPlaying(): LiveData<Resource<List<MoviesResult>>> {
        return Transformations.map(movieRepository.getNowPlayingMovies()){
            it
        }
    }

    override suspend fun getReviewByMovieId(id: Int): LiveData<Resource<List<ReviewResult>>> {
        return Transformations.map(movieRepository.getReviewMovie(id)){
            it
        }
    }

    override suspend fun getMovieById(id: Int): LiveData<MoviesResult> {
        return Transformations.map(movieRepository.getMovieId(id)){
            it
        }
    }

    override suspend fun setFavorite(isFavorite: Boolean, id: Int): LiveData<MoviesResult> {
        return Transformations.map(movieRepository.setMovieFavoriteId(isFavorite, id)){
            it
        }
    }
}