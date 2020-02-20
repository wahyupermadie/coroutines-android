package com.godohdev.themoviedb.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

class AppCoroutineContextProvider : CoroutineContextProvider {
    override fun uiDispatcher(): CoroutineContext = Dispatchers.Main

    override fun bgDispatcher(): CoroutineContext = Dispatchers.IO
}