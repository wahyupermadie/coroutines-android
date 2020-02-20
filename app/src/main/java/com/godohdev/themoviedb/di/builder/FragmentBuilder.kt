package com.godohdev.themoviedb.di.builder

import com.godohdev.themoviedb.presentation.movie.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMoviesFragment(): MoviesFragment
}