package com.godohdev.themoviedb.presentation

import android.os.Bundle
import android.view.MenuItem
import com.godohdev.themoviedb.R
import com.godohdev.themoviedb.presentation.base.BaseActivity
import com.godohdev.themoviedb.presentation.movie.MoviesFragment
import com.godohdev.themoviedb.presentation.movie.MoviesFragmentType
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun setupLayoutId(): Int = R.layout.activity_main

    override fun onActivityReady(savedInstanceState: Bundle?) {

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.menu_popular->{
                setupFragment(MoviesFragmentType.POPULAR.value, getString(R.string.lbl_popular))
            }
            R.id.menu_top_rated->{
                setupFragment(MoviesFragmentType.TOP_RATED.value, getString(R.string.lbl_top_rated))
            }
            R.id.menu_now_playing->{
                setupFragment(MoviesFragmentType.NOW_PLAYING.value, getString(R.string.Lbl_current_playing))
            }
            R.id.menu_favorite->{
                setupFragment(MoviesFragmentType.FAVORITE.value, getString(R.string.lbl_favorite))
            }
            else -> {
                setupFragment(MoviesFragmentType.POPULAR.value, getString(R.string.lbl_popular))
            }
        }
        return true
    }

    private fun setupFragment(fragmentType: String, title: String){
        supportActionBar?.title = title
        val bundle = Bundle().apply {
            this.putString(MoviesFragment.FRAGMENT_TYPE, fragmentType)
        }
        val fragment = MoviesFragment.newInstance(bundle)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragment).commit()
    }
}
