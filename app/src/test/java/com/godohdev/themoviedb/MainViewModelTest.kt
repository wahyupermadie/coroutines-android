package com.godohdev.themoviedb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.data.usecase.MovieUseCase
import com.godohdev.themoviedb.presentation.movie.MovieViewModel
import com.godohdev.themoviedb.utils.Helper.FAKE_MOVIES
import com.godohdev.themoviedb.utils.Resource
import com.godohdev.themoviedb.utils.TestCoroutineContextProvider
import io.mockk.coEvery
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 *
 * Created by Wahyu Permadi on 2020-02-22.
 * Android Engineer
 *
 **/
@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private lateinit var testDispatcher: TestCoroutineContextProvider
    private val movieUseCase: MovieUseCase = mockk(relaxed = true)
    private var moviesLiveData = MutableLiveData<Resource<List<MoviesResult>>>()
    private var movieObserver: Observer<Resource<List<MoviesResult>>> = mockk(relaxed = true)

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        testDispatcher = TestCoroutineContextProvider()
        viewModel = MovieViewModel(movieUseCase, testDispatcher)
    }

    @Test
    fun `get popular movies with success response`() {
        val data  : MutableList<MoviesResult> = mutableListOf()
        data.add(FAKE_MOVIES)
        data.add(FAKE_MOVIES)

        runBlocking {
            moviesLiveData.value = Resource(Resource.Status.SUCCESS, data, "")
            launch(testDispatcher.bgDispatcher()) {

                coEvery {
                        movieUseCase.getMovies()
                } returns moviesLiveData

            }
        }

        viewModel.movies.observeForever(movieObserver)
        viewModel.fetchMoviesPopular()
        verifyOrder {
            movieObserver.onChanged(Resource.success(data))
        }

        confirmVerified(movieObserver)
    }

    @Test
    fun `get top rated movies with success response`() {
        val data  : MutableList<MoviesResult> = mutableListOf()
        data.add(FAKE_MOVIES)
        data.add(FAKE_MOVIES)

        runBlocking {
            moviesLiveData.value = Resource(Resource.Status.SUCCESS, data, "")
            launch(testDispatcher.bgDispatcher()) {

                coEvery {
                    movieUseCase.getTopRated()
                } returns moviesLiveData

            }
        }

        viewModel.movies.observeForever(movieObserver)
        viewModel.fetchMoviesTopRated()
        verifyOrder {
            movieObserver.onChanged(Resource.success(data))
        }

        confirmVerified(movieObserver)
    }

    @Test
    fun `get top now playing with success response`() {
        val data  : MutableList<MoviesResult> = mutableListOf()
        data.add(FAKE_MOVIES)
        data.add(FAKE_MOVIES)

        runBlocking {
            moviesLiveData.value = Resource(Resource.Status.SUCCESS, data, "")
            launch(testDispatcher.bgDispatcher()) {

                coEvery {
                    movieUseCase.getNowPlaying()
                } returns moviesLiveData

            }
        }

        viewModel.movies.observeForever(movieObserver)
        viewModel.fetchMoviesNowPlaying()
        verifyOrder {
            movieObserver.onChanged(Resource.success(data))
        }

        confirmVerified(movieObserver)
    }

    @Test
    fun `get favorite with success response`() {
        val data  : MutableList<MoviesResult> = mutableListOf()
        data.add(FAKE_MOVIES)
        data.add(FAKE_MOVIES)
        runBlocking {
            moviesLiveData.value = Resource(Resource.Status.SUCCESS, data, "")
            launch(testDispatcher.bgDispatcher()) {

                coEvery {
                    movieUseCase.getFavoriteMovies()
                } returns moviesLiveData

            }
        }

        viewModel.movies.observeForever(movieObserver)
        viewModel.fetchFavorite()
        verifyOrder {
            movieObserver.onChanged(Resource.success(data))
        }

        confirmVerified(movieObserver)
    }
}

