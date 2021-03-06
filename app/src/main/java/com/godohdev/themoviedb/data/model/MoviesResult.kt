package com.godohdev.themoviedb.data.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movie_table")
@Parcelize
data class MoviesResult(

	@Json(name="overview")
	var overview: String? = "",

	@Json(name="original_language")
	var originalLanguage: String? = "",

	@Json(name="original_title")
	var originalTitle: String? = "",

	@Json(name="video")
	var video: Boolean? = false,

	@Json(name="title")
	var title: String? = "",

	@Ignore
	@Json(name="genre_ids")
	var genreIds: List<Int>? = null,

	@Json(name="poster_path")
	var posterPath: String? = "",

	@Json(name="backdrop_path")
	var backdropPath: String? = "",

	@Json(name="release_date")
	var releaseDate: String? = "",

	@Json(name="popularity")
	var popularity: Double? = 0.0,

	@Json(name="vote_average")
	var voteAverage: Double? = 0.0,

	@PrimaryKey
	@NonNull
	@Json(name="id")
	var id: Int? = 0,

	@Json(name="adult")
	var adult: Boolean? = null,

	@Json(name="vote_count")
	var voteCount: Int? = 0,

	var isFavorite: Boolean? = false,
	var isTopRated: Boolean? = false,
	var isNowPlaying: Boolean? = false
): Parcelable