package com.godohdev.themoviedb.presentation.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.databinding.FragmentMovieBinding
import com.godohdev.themoviedb.presentation.base.BaseFragment
import com.godohdev.themoviedb.presentation.detail.DetailMoviesActivity
import com.godohdev.themoviedb.utils.MoviesFragmentType
import com.godohdev.themoviedb.utils.Resource

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

class MoviesFragment : BaseFragment<MovieViewModel>(){

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter

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
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
        setupObseveData()
        val fragmentType = arguments?.get(FRAGMENT_TYPE) as String
        fetchMovies(fragmentType)
    }

    private fun initAdapter() {
        movieAdapter = MovieAdapter {
            Intent(context, DetailMoviesActivity::class.java).run {
                this.putExtra("movie", it)
                startActivity(this)
            }
        }

        binding.rvMovie.apply {
            this.adapter = movieAdapter
            this.layoutManager = GridLayoutManager(context, 3)
        }
    }

    private fun setupObseveData() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.status == Resource.Status.SUCCESS){
                    it.data?.let {
                        movieAdapter.addData(it as MutableList<MoviesResult>)
                    }
                }else{
                    it.data?.let {
                        movieAdapter.addData(it as MutableList<MoviesResult>)
                    }
                }
            }
        })
    }

    override fun getViewModel(): MovieViewModel = viewModel

    private fun fetchMovies(fragmentType: String){
        when(fragmentType){
            MoviesFragmentType.POPULAR.value -> {
                viewModel.fetchMoviesPopular()
            }
            MoviesFragmentType.NOW_PLAYING.value -> {
                viewModel.fetchMoviesNowPlaying()
            }
            MoviesFragmentType.TOP_RATED.value -> {
                viewModel.fetchMoviesTopRated()
            }
            MoviesFragmentType.FAVORITE.value -> {
                viewModel.fetchFavorite()
            }
            else -> {

            }
        }
    }

    override fun showLoading() {
        super.showLoading()
        binding.isLoading = true
    }

    override fun hideLoading() {
        super.hideLoading()
        binding.isLoading = false
    }
}