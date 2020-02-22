package com.godohdev.themoviedb.utils

import com.godohdev.themoviedb.data.model.MoviesResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-22.
 * Android Engineer
 *
 **/

object Helper {
    val FAKE_MOVIES = MoviesResult().apply {
        this.id = 6
        this.originalLanguage = "Indonesia"
        this.video = false
        this.originalTitle = "Indonesia Bisa"
        this.overview = "Tentang Kisah Seorang anak dari Bali"
    }
}