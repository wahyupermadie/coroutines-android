package com.godohdev.themoviedb.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import java.text.SimpleDateFormat
import java.util.Locale

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

enum class MoviesFragmentType(val value : String){
    POPULAR("popular"),
    NOW_PLAYING("now_playing"),
    TOP_RATED("top_rated"),
    FAVORITE("favorite"),
}

const val IMAGE_URL = "https://image.tmdb.org/t/p/w342"

fun String.dateFormat() : String{

    val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.US)
    val date = sdf.parse(this)

    val newSdf = SimpleDateFormat("dd-MMM-yyyy", Locale.US)
    return newSdf.format(date!!)
}

fun isConnected(ctx: Context?) : Boolean {
    val connectivityManager = ctx?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManager.activeNetwork != null
    } else {
        connectivityManager.activeNetworkInfo != null
    }
}