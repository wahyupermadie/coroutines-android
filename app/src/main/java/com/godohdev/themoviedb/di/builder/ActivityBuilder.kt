package com.godohdev.themoviedb.di.builder

import com.godohdev.themoviedb.di.scope.ActivityScope
import com.godohdev.themoviedb.presentation.MainActivity
import com.godohdev.themoviedb.presentation.detail.DetailMoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindDetailMoviesActivity(): DetailMoviesActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    internal abstract fun bindMainActivity() : MainActivity
}