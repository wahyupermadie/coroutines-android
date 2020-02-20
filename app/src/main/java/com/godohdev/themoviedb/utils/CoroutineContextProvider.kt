package com.godohdev.themoviedb.utils

import kotlin.coroutines.CoroutineContext

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

interface CoroutineContextProvider {
    fun uiDispatcher(): CoroutineContext
    fun bgDispatcher(): CoroutineContext
}