package com.godohdev.themoviedb.data.model

import com.squareup.moshi.Json

data class MoviesResponse<T>(

	@Json(name="page")
	val page: Int? = null,

	@Json(name="total_pages")
	val totalPages: Int? = null,

	@Json(name="results")
	val results: List<T>? = null,

	@Json(name="total_results")
	val totalResults: Int? = null
)