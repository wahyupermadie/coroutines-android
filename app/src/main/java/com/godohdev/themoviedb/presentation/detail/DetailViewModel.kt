package com.godohdev.themoviedb.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult
import com.godohdev.themoviedb.data.usecase.MovieUseCase
import com.godohdev.themoviedb.presentation.base.BaseViewModel
import com.godohdev.themoviedb.utils.CoroutineContextProvider
import com.godohdev.themoviedb.utils.Event
import com.godohdev.themoviedb.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * Created by Wahyu Permadi on 2020-02-22.
 * Android Engineer
 *
 **/

class DetailViewModel(
    private val movieUseCase: MovieUseCase,
    private val coroutineContextProvider: CoroutineContextProvider
) : BaseViewModel(){
    private var _reviews = MediatorLiveData<Resource<List<ReviewResult>>>()
    val reviews : LiveData<Resource<List<ReviewResult>>> get() = _reviews

    private var reviewSource: LiveData<Resource<List<ReviewResult>>> = MutableLiveData<Resource<List<ReviewResult>>>()

    private var _movie = MediatorLiveData<MoviesResult>()
    val movie : LiveData<MoviesResult> get() = _movie

    private var movieSource: LiveData<MoviesResult> = MutableLiveData<MoviesResult>()

    fun getMovieReview(id: Int) = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _reviews.removeSource(reviewSource)
        withContext(coroutineContextProvider.bgDispatcher()){
            reviewSource = movieUseCase.getReviewByMovieId(id)
        }
        _reviews.addSource(reviewSource){
            when(it.status){
                Resource.Status.SUCCESS -> {
                    _loadingHandler.value = false
                    _reviews.value = Resource.success(it.data)
                }
                Resource.Status.ERROR -> {
                    _loadingHandler.value = false
                    _reviews.value = Resource.error(it.error!!, it.data)
                    _errorHandler.value = Event(it.error)
                }
                Resource.Status.LOADING -> {
                    _loadingHandler.value = true
                }
            }
        }
    }

    fun getMovieById(id : Int) = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _movie.removeSource(movieSource)
        withContext(coroutineContextProvider.bgDispatcher()){
            movieSource = movieUseCase.getMovieById(id)
        }

        _movie.addSource(movieSource){
            _movie.value = it
        }
    }

    fun updateMovieFavorite(isFavorite: Boolean, id: Int) = viewModelScope.launch(coroutineContextProvider.uiDispatcher()){
        _movie.removeSource(movieSource)
        withContext(coroutineContextProvider.bgDispatcher()){
            movieSource = movieUseCase.setFavorite(isFavorite, id)
        }
        _movie.addSource(movieSource){
            Log.d("DATA_GUE","DATA "+it)
            _movie.value = it
        }
    }
}