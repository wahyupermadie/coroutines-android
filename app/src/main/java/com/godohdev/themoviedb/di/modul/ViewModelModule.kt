package com.godohdev.themoviedb.di.modul

import androidx.lifecycle.ViewModel
import com.godohdev.themoviedb.data.usecase.MovieUseCaseImpl
import com.godohdev.themoviedb.di.viewmodel.ViewModelFactory
import com.godohdev.themoviedb.di.viewmodel.ViewModelKey
import com.godohdev.themoviedb.presentation.detail.DetailViewModel
import com.godohdev.themoviedb.presentation.movie.MovieViewModel
import com.godohdev.themoviedb.utils.AppCoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

@Module
class ViewModelModule {
    @Provides
    fun viewModelFactory(providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }

    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    @Provides
    fun provideMovieViewModel(
        movieUseCaseImpl: MovieUseCaseImpl,
        coroutineContextProvider: AppCoroutineContextProvider
    ) : ViewModel = MovieViewModel(
        movieUseCaseImpl,
        coroutineContextProvider
    )

    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    @Provides
    fun provideDetailViewModel(
        movieUseCaseImpl: MovieUseCaseImpl,
        coroutineContextProvider: AppCoroutineContextProvider
    ) : ViewModel = DetailViewModel(
        movieUseCaseImpl,
        coroutineContextProvider
    )
}