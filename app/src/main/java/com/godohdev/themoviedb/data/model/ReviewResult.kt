package com.godohdev.themoviedb.data.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "review_table")
@Parcelize
data class ReviewResult(

	@Json(name="author")
	var author: String? = "",

	@PrimaryKey
	@NonNull
	@Json(name="id")
	var id: String = "",

	@Json(name="content")
	var content: String? = "",

	@Json(name="url")
	var url: String? = "",

	var movieId: Int? = 0
) : Parcelable