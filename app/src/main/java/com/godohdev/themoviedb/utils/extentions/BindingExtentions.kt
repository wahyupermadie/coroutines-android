package com.godohdev.themoviedb.utils.extentions

import android.provider.SyncStateContract
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.godohdev.themoviedb.utils.IMAGE_URL
import com.godohdev.themoviedb.utils.dateFormat

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

object BindingExtentions {

    @JvmStatic
    @BindingAdapter("srcImage")
    fun setImage(view : ImageView, url : String){
        Glide.with(view.context)
            .asBitmap()
            .thumbnail(0.1f)
            .load(IMAGE_URL+url)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("textDate")
    fun setDate(view: TextView, date: String){
        val newDate = date.dateFormat()
        view.text = newDate
    }
}