package com.godohdev.themoviedb.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.godohdev.themoviedb.R
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.model.ReviewResult
import com.godohdev.themoviedb.databinding.ActivityDetailMoviesBinding
import com.godohdev.themoviedb.di.viewmodel.ViewModelFactory
import com.godohdev.themoviedb.presentation.base.BaseActivity
import com.godohdev.themoviedb.presentation.base.BaseViewModel
import com.godohdev.themoviedb.utils.Resource
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import org.jetbrains.anko.toast
import javax.inject.Inject

class DetailMoviesActivity : BaseActivity() {
    private lateinit var binding : ActivityDetailMoviesBinding
    private lateinit var moviesResult: MoviesResult
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel : DetailViewModel
    lateinit var reviewAdapter : ReviewAdapter

    override fun setupLayoutId(): Int {
        return R.layout.activity_detail_movies
    }

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[DetailViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movies)
        moviesResult = intent.getParcelableExtra("movie")!!
        binding.movies = moviesResult
        reviewAdapter = ReviewAdapter()
        binding.rvReview.apply {
            this.adapter = reviewAdapter
        }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.reviews.observe(this, Observer {
            it?.let {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        reviewAdapter.addData(it.data as MutableList<ReviewResult>)
                    }
                    Resource.Status.ERROR -> {
                        reviewAdapter.addData(it.data as MutableList<ReviewResult>)
                    }
                }
                if (it.data?.size == 0){
                    binding.tvError.visibility = View.VISIBLE
                }else{
                    binding.tvError.visibility = View.GONE
                }
            }
        })

        viewModel.getMovieReview(moviesResult.id!!)
    }

    override fun showLoading() {
        super.showLoading()
        binding.isLoading = true
    }

    override fun isUsingViewModel(): Boolean {
        return true
    }

    override fun hideLoading() {
        super.hideLoading()
        binding.isLoading = false
    }
}
