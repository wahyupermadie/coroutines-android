package com.godohdev.themoviedb.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupObseveData()
        val fragmentType = arguments?.get(FRAGMENT_TYPE) as String
        fetchMovies(fragmentType)
    }

    private fun setupObseveData() {

    }

    override fun getViewModel(): MovieViewModel = viewModel

    private fun fetchMovies(fragmentType: String){
        when(fragmentType){
            MoviesFragmentType.POPULAR.value -> {

            }
            MoviesFragmentType.NOW_PLAYING.value -> {

            }
            MoviesFragmentType.TOP_RATED.value -> {

            }
            MoviesFragmentType.FAVORITE.value -> {

            }
            else -> {

            }
        }
    }

}

enum class MoviesFragmentType(val value : String){
    POPULAR("popular"),
    NOW_PLAYING("now_playing"),
    TOP_RATED("top_rated"),
    FAVORITE("favorite"),
}