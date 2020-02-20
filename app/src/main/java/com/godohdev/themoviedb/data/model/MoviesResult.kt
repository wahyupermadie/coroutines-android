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
	var overview: String? = null,

	@Json(name="original_language")
	var originalLanguage: String? = null,

	@Json(name="original_title")
	var originalTitle: String? = null,

	@Json(name="video")
	var video: Boolean? = null,

	@Json(name="title")
	var title: String? = null,

	@Ignore
	@Json(name="genre_ids")
	var genreIds: List<Int>? = null,

	@Json(name="poster_path")
	var posterPath: String? = null,

	@Json(name="backdrop_path")
	var backdropPath: String? = null,

	@Json(name="release_date")
	var releaseDate: String? = null,

	@Json(name="popularity")
	var popularity: Double? = null,

	@Json(name="vote_average")
	var voteAverage: Int? = null,

	@PrimaryKey
	@NonNull
	@Json(name="id")
	var id: Int? = null,

	@Json(name="adult")
	var adult: Boolean? = null,

	@Json(name="vote_count")
	var voteCount: Int? = null,

	var isFavorite: Boolean? = false
): Parcelable