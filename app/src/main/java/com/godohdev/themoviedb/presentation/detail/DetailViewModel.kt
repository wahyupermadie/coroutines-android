package com.godohdev.themoviedb.presentation.detail

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
}