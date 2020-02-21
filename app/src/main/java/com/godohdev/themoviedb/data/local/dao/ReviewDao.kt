package com.godohdev.themoviedb.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.godohdev.themoviedb.data.model.ReviewResult

/**
 *
 * Created by Wahyu Permadi on 2020-02-22.
 * Android Engineer
 *
 **/

@Dao
interface ReviewDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertReview(reviewResult: ReviewResult) : Long

    @Query("SELECT * FROM review_table WHERE movieId = :moviewId")
    suspend fun getReviewByMovieId(moviewId : Int): List<ReviewResult>
}