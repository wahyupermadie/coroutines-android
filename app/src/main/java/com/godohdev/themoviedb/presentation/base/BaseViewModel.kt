package com.godohdev.themoviedb.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.godohdev.themoviedb.utils.Event

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

abstract class BaseViewModel : ViewModel() {

    // FOR ERROR HANDLER
    protected val _errorHandler = MutableLiveData<Event<String>>()
    val errorHandler: LiveData<Event<String>> get() = _errorHandler

    protected val _loadingHandler = MutableLiveData<Boolean>(false)
    val loadingHandler: LiveData<Boolean> get() = _loadingHandler

}