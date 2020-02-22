package com.godohdev.themoviedb.presentation.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.usecase.MovieUseCase
import com.godohdev.themoviedb.presentation.base.BaseViewModel
import com.godohdev.themoviedb.utils.CoroutineContextProvider
import com.godohdev.themoviedb.utils.Event
import com.godohdev.themoviedb.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

class MovieViewModel(
    private val movieUseCase: MovieUseCase,
    private val coroutineContextProvider: CoroutineContextProvider
) : BaseViewModel(){

    private var _movies = MediatorLiveData<Resource<List<MoviesResult>>>()
    val movies : LiveData<Resource<List<MoviesResult>>> get() = _movies

    private var moviesSource: LiveData<Resource<List<MoviesResult>>> = MutableLiveData<Resource<List<MoviesResult>>>()

    fun fetchMoviesPopular() = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _movies.removeSource(moviesSource)
        withContext(coroutineContextProvider.bgDispatcher()){
            moviesSource = movieUseCase.getMovies()
        }
        _movies.addSource(moviesSource){
            when(it.status){
                Resource.Status.SUCCESS -> {
                    _movies.value = Resource.success(it.data)
                    _loadingHandler.value = false
                }
                Resource.Status.LOADING -> {
                    _loadingHandler.value = true
                }
                Resource.Status.ERROR -> {
                    _movies.value = Resource.error(it.error!!, it.data)
                    _errorHandler.value = Event(it.error)
                    _loadingHandler.value = false
                }
            }
        }
    }

    fun fetchMoviesTopRated() = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _movies.removeSource(moviesSource)
        withContext(coroutineContextProvider.bgDispatcher()){
            moviesSource = movieUseCase.getTopRated()
        }
        _movies.addSource(moviesSource){
            when(it.status){
                Resource.Status.SUCCESS -> {
                    _movies.value = Resource.success(it.data)
                    _loadingHandler.value = false
                }
                Resource.Status.LOADING -> {
                    _loadingHandler.value = true
                }
                Resource.Status.ERROR -> {
                    _movies.value = Resource.error(it.error!!, it.data)
                    _errorHandler.value = Event(it.error)
                    _loadingHandler.value = false
                }
            }
        }
    }

    fun fetchMoviesNowPlaying() = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _movies.removeSource(moviesSource)
        withContext(coroutineContextProvider.bgDispatcher()){
            moviesSource = movieUseCase.getNowPlaying()
        }
        _movies.addSource(moviesSource){
            when(it.status){
                Resource.Status.SUCCESS -> {
                    _movies.value = Resource.success(it.data)
                    _loadingHandler.value = false
                }
                Resource.Status.LOADING -> {
                    _loadingHandler.value = true
                }
                Resource.Status.ERROR -> {
                    _movies.value = Resource.error(it.error!!, it.data)
                    _errorHandler.value = Event(it.error)
                    _loadingHandler.value = false
                }
            }
        }
    }

    fun fetchFavorite() = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _movies.removeSource(moviesSource)
        _loadingHandler.value = true
        withContext(coroutineContextProvider.bgDispatcher()){
            moviesSource = movieUseCase.getFavoriteMovies()
        }
        _movies.addSource(moviesSource){
            when(it.status){
                Resource.Status.SUCCESS -> {
                    _movies.value = Resource.success(it.data)
                    _loadingHandler.value = false
                }
            }
        }
    }
}