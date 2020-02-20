package com.godohdev.themoviedb.presentation.movie

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.godohdev.themoviedb.presentation.base.BaseFragment

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

class MoviesFragment : BaseFragment<MovieViewModel>(){

    private lateinit var viewModel: MovieViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
    }

    companion object{
        const val FRAGMENT_TYPE = "fragment_type"
        fun newInstance(bundle: Bundle) : MoviesFragment{
            val fragment = MoviesFragment()
            fragment.apply {
                this.arguments = bundle
            }
            return fragment
        }
    }

    override fun getViewModel(): MovieViewModel = viewModel

}

enum class MoviesFragmentType(val value : String){
    POPULAR("popular"),
    NOW_PLAYING("now_playing"),
    TOP_RATED("top_rated"),
    FAVORITE("favorite"),
}