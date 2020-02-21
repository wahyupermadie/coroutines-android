package com.godohdev.themoviedb.utils.extentions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/
fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById<View>(android.R.id.content), snackbarText, timeLength).show() }
}

fun AppCompatActivity.showSnackbar(snackbarText: String, timeLength: Int) {
    this.let { Snackbar.make(it.findViewById<View>(android.R.id.content), snackbarText, timeLength).show() }
}