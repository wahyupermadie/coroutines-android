package com.godohdev.themoviedb.di.modul

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.godohdev.themoviedb.di.viewmodel.ViewModelFactory
import com.godohdev.themoviedb.di.viewmodel.ViewModelKey
import com.godohdev.themoviedb.presentation.movie.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun provideMoviesViewModel(moviesViewModel: MovieViewModel) : ViewModel
}