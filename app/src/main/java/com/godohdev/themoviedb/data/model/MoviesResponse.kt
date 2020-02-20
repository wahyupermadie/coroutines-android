package com.godohdev.themoviedb.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse(

	@Json(name="page")
	val page: Int? = null,

	@Json(name="total_pages")
	val totalPages: Int? = null,

	@Json(name="results")
	val results: List<MoviesResult>? = null,

	@Json(name="total_results")
	val totalResults: Int? = null
) : Parcelable