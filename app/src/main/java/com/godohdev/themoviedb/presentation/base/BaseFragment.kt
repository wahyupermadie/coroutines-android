package com.godohdev.themoviedb.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.godohdev.themoviedb.di.viewmodel.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

abstract class BaseFragment<T> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    abstract fun getViewModel() : T

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupObserver((getViewModel() as BaseViewModel))
    }

    private fun setupObserver(baseViewModel: BaseViewModel) {

    }
}