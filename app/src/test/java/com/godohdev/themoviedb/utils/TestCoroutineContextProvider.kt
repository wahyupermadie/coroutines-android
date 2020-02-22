package com.godohdev.themoviedb.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 *
 * Created by Wahyu Permadi on 2020-02-22.
 * Android Engineer
 *
 **/

class TestCoroutineContextProvider : CoroutineContextProvider{
    override fun uiDispatcher(): CoroutineContext {
        return Dispatchers.Unconfined
    }

    override fun bgDispatcher(): CoroutineContext {
        return Dispatchers.Unconfined
    }
}